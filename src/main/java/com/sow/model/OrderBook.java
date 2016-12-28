package com.sow.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "SOW_WORK_ORDER")
public class OrderBook implements Serializable {

	private static final long serialVersionUID = 8704535406621494434L;

	@Id
	@Column(name = "SOW_NO")
	private String sowNo;

	@Column(name = "PRJ_DESC")
	private Integer pId;

	@Column(name = "CONTRACT_TYPE")
	private String contractNo;
	
	@Column(name = "SOW_VALUE_USD")
	private Integer sowValueUSD;
	    
	@Column(name = "PRJECTN_Q1_1") 
	private Integer prjectnQ11;
	
	@Column(name = "PRJECTN_Q1_2") 
	private Integer prjectnQ12;
	
	@Column(name = "PRJECTN_Q1_3")  
	private Integer prjectnQ13;

	@Column(name = "PRJECTN_Q1_SUM") 
	private Integer prjectnQ1Sum;

	@Column(name = "ACTUAL_Q1_1")
	private Integer actualQ11;

	@Column(name = "ACTUAL_Q1_2") 
	private Integer actualQ12;

    @Column(name = "ACTUAL_Q1_3") 
	private Integer actualQ13;

	@Column(name = "ACTUAL_Q1_SUM")  
	private Integer actualQ1Sum;

	@Column(name = "PRJECTN_Q2_1") 
	private Integer prjectnQ21;
	
	@Column(name = "PRJECTN_Q2_2")   
	private Integer prjectnQ22;
	
	@Column(name = "PRJECTN_Q2_3")  
	private Integer prjectnQ23;
	
	@Column(name = "PRJECTN_Q2_SUM")
	private Integer prjectnQ2Sum;

	@Column(name = "ACTUAL_Q2_1")
	private Integer actualQ21;

	@Column(name = "ACTUAL_Q2_2")
	private Integer actualQ22;

	@Column(name = "ACTUAL_Q2_3")
	private Integer actualQ23;

	@Column(name = "ACTUAL_Q2_SUM")
	private Integer actualQ2Sum;

	@Column(name = "PRJECTN_Q3_1")
	private Integer prjectnQ31;

	@Column(name = "PRJECTN_Q3_2")
	private Integer prjectnQ32;
	
	@Column(name = "PRJECTN_Q3_3")
	private Integer prjectnQ33;
	
	@Column(name = "PRJECTN_Q3_SUM")  
	private Integer prjectnQ3Sum;

	@Column(name = "ACTUAL_Q3_1")	
	private Integer actualQ31;

	@Column(name = "ACTUAL_Q3_2")
	private Integer actualQ32;
	
	@Column(name = "ACTUAL_Q3_3") 
	private Integer actualQ33;

	@Column(name = "ACTUAL_Q3_SUM") 
	private Integer actualQ3Sum;

	@Column(name = "PRJECTN_Q4_1")
	private Integer prjectnQ41;

	@Column(name = "PRJECTN_Q4_2")
	private Integer prjectnQ42;

	@Column(name = "PRJECTN_Q4_3")   
	private Integer prjectnQ43;

	@Column(name = "PRJECTN_Q4_SUM") 
	private Integer prjectnQ4Sum;

	@Column(name = "ACTUAL_Q4_1") 
	private Integer actualQ41;

	@Column(name = "ACTUAL_Q4_2") 
	private Integer actualQ42;

	@Column(name = "ACTUAL_Q4_3") 
	private Integer actualQ43;

	@Column(name = "ACTUAL_Q4_SUM")  
	private Integer actualQ4Sum;

	@Column(name = "REMARKS") 
	private String remarks;
	
	@Column(name = "CREATED_DATE")
	private Date createdDate;

	@Column(name = "CREATED_BY")
	private String createdBy;

	@Column(name = "UPDATED_DATE")
	private Date updatedDate;

	@Column(name = "UPDATED_BY")
	private String updatedBy;    




}
