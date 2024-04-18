
class UpperCaseTransformer implements MyTransformer<String> {
@Override
	public String transformElement(String s) {
		return s.toUpperCase();
	}

}

// Add your transformers here
class truncate3 implements MyTransformer<String> {
@Override
	public String transformElement(String s) {
		if(s.length() > 3){
			return s.substring(0, 3) + "...";
		}
		else{return s;}
	}
}

class frontAndBack implements MyTransformer<String> {
@Override
	public String transformElement(String s){
		String head = s.substring(0,1);
		return head + s + head;
	}
}