package com.user.unit;

import java.util.List;
/**
 * @author 孔超
 * @date 2019/5/1
 * 
 * */
public class Page<T> {
	private Integer pageSize;
	//学生id
	private String user;
	//分页当前页的第一个索引
	private Integer begin;
	//分页当前页的最后一个索引
	private Integer end;
	//分类条件
	private String content;
	private Integer totalPage;
	
	private Integer currentPage=1;
	
	private List<T> dataList;
	
	private Integer totalCount;
	
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public Integer getBegin() {
		return begin;
	}
	public void setBegin(Integer begin) {
		this.begin = begin;
	}
	public Integer getEnd() {
		return end;
	}
	public void setEnd(Integer end) {
		this.end = end;
	}
	
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Page(Integer pageSize){
		this.pageSize =pageSize;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	
	public Integer getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}
	public Integer getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(Integer currentPage) {
		if(currentPage<1){
			this.currentPage=1;
		}else if(currentPage>this.totalPage){
			this.currentPage=this.totalPage;
		}else{
			this.currentPage=currentPage;
		}
		this.currentPage = currentPage;
	}
	public List<T> getDataList() {
		return dataList;
	}
	public void setDataList(List<T> dataList) {
		this.dataList = dataList;
	}
	public Integer getTotalCount() {
		
		return totalCount;
	}
	public void setTotalCount(Integer totalCount) {
	
		this.totalCount = totalCount;
		if(this.totalCount%this.pageSize==0){
			this.totalPage=this.totalCount/this.pageSize;
			
		}else{
			this.totalPage=this.totalCount/this.pageSize+1;
		}
		
	}
	@Override
	public String toString() {
		return "Page [pageSize=" + pageSize + ", user=" + user + ", begin=" + begin + ", end=" + end + ", content="
				+ content + ", totalPage=" + totalPage + ", currentPage=" + currentPage + ", dataList=" + dataList
				+ ", totalCount=" + totalCount + "]";
	}
	
	
	
}
