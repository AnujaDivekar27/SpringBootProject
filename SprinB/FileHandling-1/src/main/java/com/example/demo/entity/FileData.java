package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import javax.persistence.Lob;

@Entity
public class FileData {

	@Id
	private int fid;

	private String fname;

	private String ftype;

	@Lob
	private byte[] fdata;

	public int getFid() {
		return fid;
	}

	public void setFid(int fid) {
		this.fid = fid;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getFtype() {
		return ftype;
	}

	public void setFtype(String ftype) {
		this.ftype = ftype;
	}

	public byte[] getFdata() {
		return fdata;
	}

	public void setFdata(byte[] fdata) {
		this.fdata = fdata;
	}

}
