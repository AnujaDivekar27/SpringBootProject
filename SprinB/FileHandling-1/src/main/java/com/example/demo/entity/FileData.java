package com.example.demo.entity;

import java.util.Arrays;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Lob;

@Entity
public class FileData {

	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
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

	@Override
	public String toString() {
		return "FileData [fid=" + fid + ", fname=" + fname + ", ftype=" + ftype + ", fdata=" + Arrays.toString(fdata)
				+ "]";
	}
	
}
