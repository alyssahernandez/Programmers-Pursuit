package com.sideprojects.trivialpursuit.model;

import java.util.List;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

public class GameCreationForm {
	
	@NotEmpty(message="Please select 2, 3, or 6 categories")
	@NotNull(message="Please select 2, 3, or 6 categories")
	private List<Integer> selectedCategories;
	
	@NotBlank(message="Please select Public or Private")
	@NotNull(message="Please select Public or Private")
	private String publicOrPrivate;
	
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
	
	public String getPublicOrPrivate() { return publicOrPrivate; }
	public void setPublicOrPrivate(String publicOrPrivate) { this.publicOrPrivate = publicOrPrivate; }

}
