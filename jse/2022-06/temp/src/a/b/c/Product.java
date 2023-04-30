package a.b.c;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@NoArgsConstructor(access=lombok.AccessLevel.PUBLIC)
@Getter(lombok.AccessLevel.PUBLIC)
@Setter(lombok.AccessLevel.PUBLIC)
public class Product<T, M> {
	private T kind;
	private M model;
} //end class
