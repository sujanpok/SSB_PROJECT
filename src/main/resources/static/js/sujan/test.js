
function setShowHide() {
	var show = document.form3.drivingLicenseLabel.value;

	if (show == "有り") {
		$("#drivingLicense").addClass("visibility_test");
		$("#drivingLicense").removeClass("visibility_test1");
	} else {
		$("#drivingLicense").removeClass("visibility_test");
		$("#drivingLicense").addClass("visibility_test1");
	}

}