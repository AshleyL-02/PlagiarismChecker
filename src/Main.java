public class Main {
    public static void main(String[] args) {
        Converter c = new Converter("i love dOGs so, much. don't dude YEA");
        Converter d = new Converter("I LOVE dogs so much!! They're cool. I don't dude YEA");
        
        System.out.println(c.getNGrams().size() + ", " + d.getNGrams().size());
        System.out.println(Comparer.compareNGrams(c.getNGrams(), d.getNGrams()));
    }
}
