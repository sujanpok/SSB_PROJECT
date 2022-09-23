package com.example.demo.controller.sujan.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "entry_table")
public class SujanEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	/**
	 * 名前
	 */
	@Column(name = "name")
	private String name;

	/**
	 * 国籍
	 */
	@Column(name = "nationality")
	private boolean nationality;
	/**
	 * 性別
	 */
	@Column(name = "gender")
	private String gender;
	/**
	 * 年
	 */
	@Column(name = "date_Of_Year")
	private String dateOfYear;
	/**
	 * 月
	 */
	@Column(name = "date_Of_Month")
	private String dateOfMonth;
	/**
	 * 日
	 */
	@Column(name = "date_Of_Day")
	private String dateOfDay;
	/**
	 * 結婚
	 */
	@Column(name = "merriage")
	private String merriage;
	/**
	 * メールアドレス
	 */
	@Column(name = "email")
	private String email;
	/**
	 * 電話１
	 */
	@Column(name = "mobile_No1")
	private String mobileNo1;
	/**
	 * 電話２
	 */
	@Column(name = "mobile_No2")
	private String mobileNo2;
	/**
	 * 電話３
	 */
	@Column(name = "mobile_No3")

	private String mobileNo3;
	/**
	 * 郵便番号
	 */
	@Column(name = "post_NO")
	private String postNO;
	/**
	 * 住所１
	 */
	@Column(name = "address1")
	private String address1;
	/**
	 * 住所２
	 */
	@Column(name = "address2")
	private String address2;
	/**
	 * 居住状況
	 */
	@Column(name = "living_Situation")
	private String livingSituation;
	/**
	 * 自宅ローン
	 */
	@Column(name = "housing_Loan")
	private String housingLoan;
	/**
	 * 免許
	 */
	@Column(name = "driving_License_Label")
	private String drivingLicenseLabel;
	/**
	 * 免許番号
	 */
	@Column(name = "driving_License")
	private String drivingLicense;
	/**
	 * ログインID
	 */
	@Column(name = "user_Id")
	private String userId;
	/**
	 * パスワード
	 */
	@Column(name = "pwd")
	private String pwd;
	/**
	 * 再パスワード
	 */
	@Column(name = "re_Pwd")
	private String rePwd;

	/**
	 * 更新日時
	 */
	@Column(name = "update_date")
	private Date updateDate;
	/**
	 * 登録日時
	 */
	@Column(name = "create_date")
	private Date createDate;
	/**
	 * 削除日時
	 */
	@Column(name = "delete_date")
	private Date deleteDate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isNationality() {
		return nationality;
	}

	public void setNationality(boolean nationality) {
		this.nationality = nationality;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getDateOfYear() {
		return dateOfYear;
	}

	public void setDateOfYear(String dateOfYear) {
		this.dateOfYear = dateOfYear;
	}

	public String getDateOfMonth() {
		return dateOfMonth;
	}

	public void setDateOfMonth(String dateOfMonth) {
		this.dateOfMonth = dateOfMonth;
	}

	public String getDateOfDay() {
		return dateOfDay;
	}

	public void setDateOfDay(String dateOfDay) {
		this.dateOfDay = dateOfDay;
	}

	public String getMerriage() {
		return merriage;
	}

	public void setMerriage(String merriage) {
		this.merriage = merriage;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobileNo1() {
		return mobileNo1;
	}

	public void setMobileNo1(String mobileNo1) {
		this.mobileNo1 = mobileNo1;
	}

	public String getMobileNo2() {
		return mobileNo2;
	}

	public void setMobileNo2(String mobileNo2) {
		this.mobileNo2 = mobileNo2;
	}

	public String getMobileNo3() {
		return mobileNo3;
	}

	public void setMobileNo3(String mobileNo3) {
		this.mobileNo3 = mobileNo3;
	}

	public String getPostNO() {
		return postNO;
	}

	public void setPostNO(String postNO) {
		this.postNO = postNO;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getLivingSituation() {
		return livingSituation;
	}

	public void setLivingSituation(String livingSituation) {
		this.livingSituation = livingSituation;
	}

	public String getHousingLoan() {
		return housingLoan;
	}

	public void setHousingLoan(String housingLoan) {
		this.housingLoan = housingLoan;
	}

	public String getDrivingLicenseLabel() {
		return drivingLicenseLabel;
	}

	public void setDrivingLicenseLabel(String drivingLicenseLabel) {
		this.drivingLicenseLabel = drivingLicenseLabel;
	}

	public String getDrivingLicense() {
		return drivingLicense;
	}

	public void setDrivingLicense(String drivingLicense) {
		this.drivingLicense = drivingLicense;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getRePwd() {
		return rePwd;
	}

	public void setRePwd(String rePwd) {
		this.rePwd = rePwd;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getDeleteDate() {
		return deleteDate;
	}

	public void setDeleteDate(Date deleteDate) {
		this.deleteDate = deleteDate;
	}

}
