package com.example.demo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name = "sqltable")

public class SqlTable implements Serializable {

	

	
		@Id
		
	    @GeneratedValue(strategy = GenerationType.AUTO)

		private int id;
		@Column(name = "name")
		private String name;
		@Column(name = "status")

		private String status;

	    @ManyToOne(fetch = FetchType.LAZY, optional = false)
	    @JoinColumn(name = "bookid", nullable = false)
		 private Books books;
	

		

		public Books getBooks() {
			return books;
		}

		public void setBooks(Books books) {
			this.books = books;
		}


		public SqlTable(int id, String name, String status, Books books) {
			super();
			this.id = id;
			this.name = name;
			this.status = status;
			this.books = books;
		}

		public SqlTable() {
			super();
			// TODO Auto-generated constructor stub
		}


		@Override
		public String toString() {
			return "SqlTable [id=" + id + ", name=" + name + ", status=" + status + ", books=" + books + "]";
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
		}

	}


