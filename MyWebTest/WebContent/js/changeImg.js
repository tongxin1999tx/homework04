function changeImg() {
	var codeImg = document.getElementById("Verifyimg");
	codeImg.src = "servlet/CreateVerify?t=" + Math.random();
 }
