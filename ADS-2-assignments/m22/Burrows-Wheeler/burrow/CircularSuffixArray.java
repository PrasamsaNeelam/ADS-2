import edu.princeton.cs.algs4.SuffixArrayX;

public class CircularSuffixArray {
    private final SuffixArrayX sa;
    public CircularSuffixArray(String s) {
        if (s == null) {
            throw new NullPointerException();
        }
        sa = new SuffixArrayX(s);
    }

    public int length() {
        return sa.length();
    }

    /**
     * returns index of ith sorted suffix.
     *
     * @param i    the index of the ith sorted suffix
     * 
     * @return  integer type
     */
    public int index(int i) {
        return sa.index(i);
    }

}
