package com.sideprojects.trivialpursuit.model;

import java.util.List;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

public class CategorySelectionForm {
	
	@NotEmpty(message="Please select 2, 3, or 6 categories")
	@NotNull(message="Please select 2, 3, or 6 categories")
	private List<Integer> selectedCategories;
	
	private boolean validNumberOfCategories;
	@AssertTrue(message="Please select 2, 3, or 6 categories")
	public boolean isValidNumberOfCategories() {
		return selectedCategories.size() == 2 || selectedCategories.size() == 3 || selectedCategories.size() == 6;
	}

	public List<Integer> getSelectedCategories() {
		return selectedCategories;
	}

	public void setSelectedCategories(List<Integer> selectedCategories) {
		this.selectedCategories = selectedCategories;
	}

	public void setValidNumberOfCategories(boolean validNumberOfCategories) {
		this.validNumberOfCategories = validNumberOfCategories;
	}
}
