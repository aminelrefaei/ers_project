package com.revature.model;

public class Request {
	
		private int ticketid;
		private int employeeid;
		private int total;
		private String description;
		private String status;
		private int resolvedBy;
		
		public Request() {
			this.description = "";
			this.status = "";
		}

		public Request(int employeeid) {
			this();
			this.employeeid = employeeid;
		}
		
		public Request(String description) {
			this();
			this.description = description;
		}
		
		public Request(String description, String status) {
			this();
			this.description = description;
			this.status = status;
		}
		
		public Request(int employeeid, int total, String description, String status) {
			this();
			this.employeeid = employeeid;
			this.total = total;
			this.description = description;
			this.status = status;
		}
		
		public Request(int employeeid, int total, String description, String status, int resolvedBy) {
			this();
			this.employeeid = employeeid;
			this.total = total;
			this.description = description;
			this.status = status;
			this.resolvedBy = resolvedBy;
		}

		public Request(int ticketid, int employeeid, int total, String description, String status, int resolvedBy) {
			this();
			this.ticketid = ticketid;
			this.employeeid = employeeid;
			this.total = total;
			this.description = description;
			this.status = status;
			this.resolvedBy = resolvedBy;
		}
		

		public int getTicketId() {
			return ticketid;
		}

		public int getEmployeeId() {
			return employeeid;
		}
		
		public void setId(int employeeid) {
			this.employeeid = employeeid;
		}
		
		public int getTotal() {
			return total;
		}

		public void setTotal(int total) {
			this.total = total;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
		}

		public int getResolvedBy() {
			return resolvedBy;
		}

		public void setResolvedBy(int resolvedBy) {
			this.resolvedBy = resolvedBy;
		}


		@Override
		public String toString() {
			return "Request [employeeid=" + employeeid + "total=" + total + ", description=" + description + ", status=" + status + ", resolved by="
					+ resolvedBy + "]";
		}
	}


