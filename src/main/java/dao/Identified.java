package main.java.dao;

import java.io.Serializable;

public interface Identified<PK extends Serializable> {
	 public PK getId();
}
