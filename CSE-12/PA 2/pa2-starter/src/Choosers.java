
class LongWordChooser implements MyChooser<String> {
	@Override
	public boolean chooseElement(String s) {
		return s.length() > 5;
	}
} 

// Add your choosers here
class NoCc implements MyChooser<String> {
	@Override
	public boolean chooseElement(String s) {
	  return !s.contains("C") && !s.contains("c");
	}
}

class ChooseAa implements MyChooser<String> {
	@Override
	public boolean chooseElement(String s) {
	  return s.contains("A") || s.contains("a");
	}
}