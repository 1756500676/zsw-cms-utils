package com.zhenshuaiwei.utils;

public class PageUtil {
	private String page;//请求页
	private int pageSize;//每页展示的记录数
	private int count;//总记录数
	
	private int prevPage;//上一页
	private int nextPage;//下一页
	private int currentPage;//处理后的当前页
	private int lastPage;//总记录数
	private int startIndex;//每页起始索引值
	private String mohu;
	//页面样式
	private String pageStyle;
	/**
	 * @param page	页面未处理的请求页
	 * @param count 查询出来的总记录数
	 * @param pageSize 每页的记录数
	 */
	public PageUtil(String page, int count, int pageSize) {
		super();
		this.page = page;
		this.pageSize = pageSize;
		this.count = count;
		//将计算的统计出来
		
		//处理当前页
		if(page==null || page == ""){
			this.currentPage = 1;
		}else{
			this.currentPage = Integer.parseInt(page);
		}
		
		//处理上一页
		if(this.currentPage <= 1){
			this.prevPage = 1;
		}else{
			this.prevPage = this.currentPage -1;
		}
		
		//处理尾页
		if(count%pageSize == 0){
			this.lastPage = count/pageSize;
		}else{
			this.lastPage = count/pageSize + 1;
		}
		
		//处理下一页
		if(this.currentPage == this.lastPage){
			this.nextPage = this.lastPage;
		}else{
			this.nextPage = this.currentPage + 1;
		}
		
		//得到每页起始索引值
		this.startIndex = (this.currentPage - 1)* pageSize;
		
		initPageStyle();//初始化页面 分页 样式
	}
	/**
	 * 初始化分页样式，简化jsp页面代码
	 */
	private void initPageStyle() {
		StringBuffer sb = new StringBuffer();
		sb.append("当前第"+this.currentPage+"/"+this.lastPage+"页,共"+this.count+"条记录\n");
		//if(this.currentPage!=1){
			sb.append("<input type='button' value='首页' onclick='goPage(1)'/>\n");
			sb.append("<input type='button' value='上一页' onclick='goPage("+this.prevPage+")'/>\n");
		//}
		int currentPage=this.currentPage;
		int lastPage=this.lastPage;
		
		if(lastPage>5){
			if(currentPage>2 && currentPage<(lastPage-1)){
				sb.append("<input type='button' name='currentPage'  value='"+(currentPage-2)+"' onclick='goPage("+(currentPage-2)+")'/>\n");
				sb.append("<input type='button' name='currentPage'  value='"+(currentPage-1)+"' onclick='goPage("+(currentPage-1)+")'/>\n");
				sb.append("<input type='button' name='currentPage'  value='"+currentPage+"' onclick='goPage("+currentPage+")'/>\n");
				sb.append("<input type='button' name='currentPage'  value='"+(currentPage+1)+"' onclick='goPage("+(currentPage+1)+")'/>\n");
				sb.append("<input type='button' name='currentPage'  value='"+(currentPage+2)+"' onclick='goPage("+(currentPage+2)+")'/>\n");
			}else if(currentPage==2){
				sb.append("<input type='button' name='currentPage'  value='"+(currentPage-1)+"' onclick='goPage("+(currentPage-1)+")'/>\n");
				sb.append("<input type='button' name='currentPage'  value='"+currentPage+"' onclick='goPage("+currentPage+")'/>\n");
				sb.append("<input type='button' name='currentPage'  value='"+(currentPage+1)+"' onclick='goPage("+(currentPage+1)+")'/>\n");
				sb.append("<input type='button' name='currentPage'  value='"+(currentPage+2)+"' onclick='goPage("+(currentPage+2)+")'/>\n");
			}else if(currentPage==1){
				sb.append("<input type='button' name='currentPage'  value='"+currentPage+"' onclick='goPage("+currentPage+")'/>\n");
				sb.append("<input type='button' name='currentPage'  value='"+(currentPage+1)+"' onclick='goPage("+(currentPage+1)+")'/>\n");
				sb.append("<input type='button' name='currentPage'  value='"+(currentPage+2)+"' onclick='goPage("+(currentPage+2)+")'/>\n");
			}else if(currentPage==lastPage){
				sb.append("<input type='button' name='currentPage'  value='"+(currentPage-2)+"' onclick='goPage("+(currentPage-2)+")'/>\n");
				sb.append("<input type='button' name='currentPage'  value='"+(currentPage-1)+"' onclick='goPage("+(currentPage-1)+")'/>\n");
				sb.append("<input type='button' name='currentPage'  value='"+currentPage+"' onclick='goPage("+currentPage+")'/>\n");
			}else if(currentPage==(lastPage-1)){
				sb.append("<input type='button' name='currentPage'  value='"+(currentPage-2)+"' onclick='goPage("+(currentPage-2)+")'/>\n");
				sb.append("<input type='button' name='currentPage'  value='"+(currentPage-1)+"' onclick='goPage("+(currentPage-1)+")'/>\n");
				sb.append("<input type='button' name='currentPage'  value='"+currentPage+"' onclick='goPage("+currentPage+")'/>\n");
				sb.append("<input type='button' name='currentPage'  value='"+(currentPage+1)+"' onclick='goPage("+(currentPage+1)+")'/>\n");
			}
		}else{
			for (int i=1;i<=lastPage;i++) {
				sb.append("<input type='button' name='currentPage' value='"+i+"' onclick='goPage("+i+")'/>\n");
			}
		}
		//if(this.currentPage!=this.lastPage){
			sb.append("<input type='button' value='下一页' onclick='goPage("+this.nextPage+")'/>\n");
			sb.append("<input type='button' value='尾页' onclick='goPage("+this.lastPage+")'/>\n");
		//}
		
		sb.append("\n<script type='text/javascript'>\n");
		sb.append("function goPage(page){\n");
		sb.append("		location.href = changeURLArg('page',page);\n");
		sb.append("}\n");
		sb.append("function inputPage(lastPage){\n");
		sb.append("		var page = document.getElementById('inputPage').value;\n");
		sb.append("		if(!(isNaN(page)) && page.indexOf('+')==-1 && page.indexOf('-')==-1 && page.indexOf('.')==-1){\n");
		sb.append("			if(page>0&&page!=''){\n");
		sb.append("				if(page<=lastPage){\n");
		sb.append("					location.href = changeURLArg('page',page);\n");
		sb.append("				}else{\n");
		sb.append("					alert('您输入的超过了总页码!');\n");
		sb.append("				}\n");
		sb.append("			}else{\n");
		sb.append("				alert('您输入的不符合标准!');\n");
		sb.append("			}\n");
		sb.append("			}else{\n");
		sb.append("				alert('您输入的不符合标准!');\n");
		sb.append("		}\n");
		sb.append("}\n");
		sb.append("function mohu(){\n");
		
//		为模糊赋值
		sb.append("		$('form').append(\"<input type='hidden' id='mohuv'>\")\n");
		sb.append("		$('#mohuv').val('&'+$('form').serialize());\n");
		
		sb.append("		location.href = changeURLArg('mohu',document.getElementById('mohuv').value,1);\n");
		sb.append("}\n");
		sb.append("function changeURLArg(arg,arg_val,flag){\n");
		sb.append("		var url = window.location.toString(); \n");
		sb.append("		if(1==flag){\n");
		sb.append("			url = changeURLArg('page',1);\n");
		sb.append("		}\n");
		sb.append("		var pattern=arg+'=([^&]*)'; \n");
		sb.append("		var replaceText=arg+'='+arg_val; \n");
		sb.append("		if(url.match(pattern)){ \n");
		
//		替换规则为传入的arg=***,所以模糊需要判断替换
		sb.append("			if(flag==1){ \n");
		sb.append("			    var tmp='/('+ arg+'=)([^\\w]*)/gi'; \n");
		sb.append("			}else{ \n");
		sb.append("				var tmp='/('+ arg+'=)([^&]*)/gi';	\n");
		sb.append("			} \n");
		
		sb.append("		    tmp=url.replace(eval(tmp),replaceText); \n");
		sb.append("		    return tmp; \n");
		sb.append("		 }else{ \n");
		sb.append("		    if(url.match('[\\?]')){ \n");
		sb.append("		    	return url+'&'+replaceText; \n");
		sb.append("		    }else{ \n");
		sb.append("		    	return url+'?'+replaceText; \n");
		sb.append("		    } \n");
		sb.append("		 } \n");
		sb.append("		 return url+'\\n'+arg+'\\n'+arg_val; \n");
		sb.append("} \n");
		sb.append("$('[value="+currentPage+"][name=currentPage]').css({'background':'red'}); \n");
		sb.append("</script>\n");
		sb.append("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
		sb.append("<input type='text' value="+currentPage+" id='inputPage' style='width:40px'>\n");
		sb.append("<input type='button' value='搜索' onclick='inputPage("+lastPage+")'>\n");
		this.pageStyle = sb.toString();
	}
	public PageUtil() {
		super();
	}
	public String getPage() {
		return page;
	}
	public void setPage(String page) {
		this.page = page;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getPrevPage() {
		return prevPage;
	}
	public void setPrevPage(int prevPage) {
		this.prevPage = prevPage;
	}
	public int getNextPage() {
		return nextPage;
	}
	public void setNextPage(int nextPage) {
		this.nextPage = nextPage;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getLastPage() {
		return lastPage;
	}
	public void setLastPage(int lastPage) {
		this.lastPage = lastPage;
	}
	public int getStartIndex() {
		return startIndex;
	}
	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
	}
	public String getPageStyle() {
		return pageStyle;
	}
	public void setPageStyle(String pageStyle) {
		this.pageStyle = pageStyle;
	}
    public String getMohu() {
		return mohu;
	}
	public void setMohu(String mohu) {
		this.mohu = mohu;
	}
	@Override
	public String toString() {
		return "PageUtil [page=" + page + ", pageSize=" + pageSize + ", count="
				+ count + ", prevPage=" + prevPage + ", nextPage=" + nextPage
				+ ", currentPage=" + currentPage + ", lastPage=" + lastPage
				+ ", startIndex=" + startIndex + "]";
	}
}
