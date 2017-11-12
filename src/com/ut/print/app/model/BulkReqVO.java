package com.ut.print.app.model;

import java.util.LinkedList;
import java.util.List;

public class BulkReqVO {

	List<BulkReqParticulars> bulkReqParticulars;

	
	public List<BulkReqParticulars> getBulkReqParticulars() {
		if (bulkReqParticulars == null)
			bulkReqParticulars = new LinkedList<>();
		return bulkReqParticulars;
	}

	public void setBulkReqParticulars(List<BulkReqParticulars> bulkReqParticulars) {
		this.bulkReqParticulars = bulkReqParticulars;
	}
}
