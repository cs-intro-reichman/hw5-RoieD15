public class d {
    public static void playHand(String hand) {
		int totalScore = 0;
		In in = new In();
		
		while (hand.length() > 0) {
			System.out.println("Current Hand: " + MyString.spacedString(hand));
			System.out.println("Enter a word, or '.' to finish playing this hand:");
			String input = in.readString();
	
			if (input.equals(".")) {
				System.out.println("End of hand. Total score: " + totalScore + " points");
				break;
			}
	
			if (MyString.subsetOf(input, hand)) 
			{
				if (isWordInDictionary(input)) 
				{
					int score = wordScore(input);
					totalScore += score;
					hand = MyString.remove(hand, input);
					System.out.println(input + " earned " + score + " points. Score: " + totalScore + " points\n");
				} 
				else 
				{
					System.out.println("No such word in the dictionary. Try again.");
				}
			} 
			else 
			{
				System.out.println("Invalid word. Try again.");
			}
		}
	
		if (hand.isEmpty()) {
			System.out.println("End of hand. Total score: " + totalScore + " points");
		}
	}
    
}
