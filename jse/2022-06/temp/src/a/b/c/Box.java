package a.b.c;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Box<T> {
	private T obj;
} //end class
