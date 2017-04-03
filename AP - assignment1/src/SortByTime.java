//Author is Wen Zhang
//This class for comparing the time of each athlete.
import java.util.Comparator;

public class SortByTime implements Comparator {

	@Override
	public int compare(Object o1, Object o2) {
		CompeteResult c1 = (CompeteResult)o1;
		CompeteResult c2 = (CompeteResult)o2;
		if(c1.getTime()>=c2.getTime()){
			return 1;
		}
		return -1;
	}

}
