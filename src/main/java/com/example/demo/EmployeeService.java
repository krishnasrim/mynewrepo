package com.example.demo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.io.*;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

	@Autowired
	EmployeeRepository repository;
	@Autowired
	BooksRepository booksRepository;

	public List<Employee> getAllEmployees() {
		List<Employee> employeeList = repository.findAll();

		if (employeeList.size() > 0) {
			return employeeList;
		} else {
			return new ArrayList<Employee>();
		}
	}
	
    @Cacheable("employee")


	public Employee getEmployeeById(Long id) throws RecordNotFoundException, InterruptedException {
		Optional<Employee> employee = repository.findById(id);

		if (employee.isPresent()) {
			 Thread.sleep(1000*5);
			return employee.get();
		} else {
			throw new RecordNotFoundException("No employee record exist for given id");
		}
	}

	public Employee createOrUpdateEmployee(Employee entity) throws RecordNotFoundException {
		Optional<Employee> employee = repository.findById(entity.getId());

		if (employee.isPresent()) {
			Employee newEntity = employee.get();
			newEntity.setEmail(entity.getEmail());
			newEntity.setFirstName(entity.getFirstName());
			newEntity.setLastName(entity.getLastName());

			newEntity = repository.save(newEntity);

			return newEntity;
		} else {
			entity = repository.save(entity);

			return entity;
		}
	}

	public void saveOrUpdate(Books books) {
		booksRepository.save(books);
	}

	public List<Books> getAllBooks() {
		List<Books> books = new ArrayList<Books>();
		booksRepository.findAll().forEach(books1 -> books.add(books1));
		return books;
	}

	public void deleteEmployeeById(Long id) throws RecordNotFoundException {
		Optional<Employee> employee = repository.findById(id);

		if (employee.isPresent()) {
			repository.deleteById(id);
		} else {
			throw new RecordNotFoundException("No employee record exist for given id");
		}
	}

	public JSONObject jsonparsing(JSONObject inputData) throws JsonParsingException {
		JSONObject output = new JSONObject();
		if ((JSONObject) inputData != null) {
			HashMap responseObj = (HashMap) inputData.get("message");
			if (responseObj.containsKey("first")) {
				HashMap newObj = new HashMap();
				HashMap oldObj = (HashMap) responseObj.get("first");
				Set<String> rateByVendorKeySet = oldObj.keySet();
				float successrate = 0;
				for (String VendorKey : rateByVendorKeySet) {
					HashMap vendorMap = new HashMap();
					HashMap vendorObj = (HashMap) oldObj.get(VendorKey);
					String numerator = String.valueOf(vendorObj.get("numerator").toString());
					String denominator = String.valueOf(vendorObj.get("denominator").toString());
					successrate = (Float.parseFloat(numerator) / Float.parseFloat(denominator)) * 100;
					// Calculate success rate for vendor
					if (Float.isNaN(successrate)) {
						successrate = 0;
					}
					vendorMap.put("successrate", successrate);
					vendorMap.put("denominator", denominator);
					vendorMap.put("numerator", numerator);
					newObj.put(VendorKey, vendorMap);
				}
				output.put("first", newObj);

			} else {
				output.put("first", "null");
			}
		}
		return output;
	}
	
	public JSONObject sonmodulesShortNames() throws IOException, ParseException,FileNotFoundException {
		JSONParser jsonParser = new JSONParser();
		JSONObject obj = null;
		try {
			FileReader reader = new FileReader("D:\\");
			System.out.println(reader);

			obj = (JSONObject) jsonParser.parse(reader);
			System.out.println(obj);

		} catch (IOException e) {
			System.out.println(e.getMessage());
		}catch (ParseException e) {
			System.out.println(e.getMessage());
		}

		return obj;

	}
	

    @Cacheable("student")
    public Employee getStudentByID(String id) 
    {
        try
        {
            System.out.println("Going to sleep for 5 Secs.. to simulate backend call.");
            Thread.sleep(1000*5);
        } 
        catch (InterruptedException e) 
        {
            e.printStackTrace();
        }
 
        return new Employee((long) 30,"Sajal" ,"V","sd");
    }
}
