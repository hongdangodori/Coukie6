function isArgumentsSizeIsThreeAndThirdArgsMustBeOneHundred() {
	if(arguments.length != 3 || arguments[2] != 100){
		return false;
	}
	return true;
}