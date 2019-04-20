# PageStateLayout

一款简单的页面切换布局组件

## 使用

* layout.xml中使用

		<com.ljb.page.PageStateLayout xmlns:android="http://schemas.android.com/apk/res/android"
		    xmlns:app="http://schemas.android.com/apk/res-auto"
		    android:id="@+id/page_layout"
		    android:layout_width="match_parent"
		    android:layout_height="match_parent"
		    android:background="@android:color/white"
		    app:page_empty="@layout/layout_page_empty"
		    app:page_error="@layout/layout_page_error"
		    app:page_load="@layout/layout_page_loading"
		    app:page_content="@layout/layout_page_content"/>

* 或者code中使用
		   
        page_layout.setLoadView(R.layout.layout_page_loading)
        page_layout.setEmptyView(R.layout.layout_page_empty)
        page_layout.setErrorView(R.layout.layout_page_error)
        page_layout.setContentView(R.layout.layout_page_content)


* 代码切换布局

		page_layout.setPage(pageState)   

* pageState取值

		PageStateLayout.PageState.STATE_SUCCESS -> 成功页面 
		PageStateLayout.PageState.STATE_EMPTY -> 空页面 
		PageStateLayout.PageState.STATE_ERROR -> 错误页面 
		PageStateLayout.PageState.STATE_LOADING -> 加载页面 

		
 		