package datastructure.binaryLUT;

/**
 * <dl>
 * <dt>Purpose: Implementation of LUT using ordered linear search.
 * <dd>
 *
 * <dt>Description:
 * <dd>This class is an implementation of the look-up table abstract data type
 * that uses a sequence array as the underlying data structure. The capacity
 * of the LUT is thus limited. The elements of the look-up table are stored
 * in reverse alphabetical order and linear search is used for retrieval.
 * </dl>
 *
 * @author Danny Alexander
 * @version $Date: 2000/01/29
 */

public class OrderedLinearLUT extends LinearLUT {

  /**
   * Default constructor creates a default size sequence to store the LUT.
   */
  public OrderedLinearLUT() {
    super();
  }

  /**
   * Constructs a look-up table of specified maximum capacity.
   */
  public OrderedLinearLUT(int size) {
    super(size);
  }

  /**
   * Inserts a new key-value pair into the look-up table.
   */
  public void insert(String key, Object value) throws SequenceArrayException {

    //insert method overridden to put the entries in the sequence
    //ordered by the key value.
    Entry newEntry = new Entry(new Key(key), value);
    int index = 0;

    while (index < seq.size() && newEntry.key.lessThan(keyAt(index))) {
      index += 1;
    }

    seq.insert(newEntry, index);
  }

  /**
   * Performs linear search on the sequence holding the LUT and returns
   * the index of the entry containing the specified key. If no match is
   * found an index of -1 is returned.
   */
  protected int linearSearch(Key k) {

    //Override the linear search method to exploit the ordering of
    //the entries in the sequence. We can detect failed searches
    //before reaching the end of the table.
    int i = 0;
    while (i < seq.size() && k.lessThan(keyAt(i))) {
      i += 1;
    }

    //The index found is either greater than or equal to k
    if (i < seq.size() && k.equals(keyAt(i))) {
      return i;
    }

    //If it is not equal, the search has failed.
    return -1;
  }

}

