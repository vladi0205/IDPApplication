package com.vlad.myIDPApp;

public class Doc {
	private String docNo;
	private String docName;
	
	public Doc(String docNo, String docName) {
		this.docName = docName;
		this.docNo = docNo;
	}

	public String getDocName() {
		return docName;
	}
	public void setDocName(String docName) {
		this.docName = docName;
	}
	public String getDocNo() {
		return docNo;
	}
	public void setDocNo(String docNo) {
		this.docNo = docNo;
	}
	
}
