package com.example.quizservice;

public class QuizDto {
private String category;
private Integer numQ;
private String title;
public String getCategory() {
	return category;
}
public void setCategory(String category) {
	this.category = category;
}
public Integer getNumQ() {
	return numQ;
}
public void setNumQ(Integer numQ) {
	this.numQ = numQ;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
@Override
public String toString() {
	return "QuizDto [category=" + category + ", numQ=" + numQ + ", title=" + title + "]";
}
}
