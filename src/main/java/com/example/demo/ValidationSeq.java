package com.example.demo;

import javax.validation.GroupSequence;

import com.example.demo.ValidationSeqInterface.First;
import com.example.demo.ValidationSeqInterface.Second;

public class ValidationSeq {
	@GroupSequence({ First.class, Second.class })
	public interface All {

	}
}