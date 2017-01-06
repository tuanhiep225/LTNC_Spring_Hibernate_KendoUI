package mta.th12a.tuanhiep.dto;

import java.util.List;

public abstract class BaseDTO<T> {
	protected List<T> data;
	protected int itemCount;
	public BaseDTO() {
	}
	public BaseDTO(List<T> data, int itemCount) {
		this.data = data;
		this.itemCount = itemCount;
	}
	public List<T> getData() {
		return data;
	}
	public void setData(List<T> data) {
		this.data = data;
	}
	public int getItemCount() {
		return itemCount;
	}
	public void setItemCount(int itemCount) {
		this.itemCount = itemCount;
	}
}
