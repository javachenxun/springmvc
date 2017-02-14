##Springmvc源码分析

####1.主要流程类
#####1.1了解三个重要的Servelt：
	HttpServlet
	   ^
	   |
	HttpServletBean：，不参实际请求的处理
	   ^
	   |
	FrameworkServlet：将不同的请求合并到processRequest(request, response)中，调用子类DispatcherServlet的doService（），这属于模板方法
	   ^
	   |
	DispatcherServlet ：doService（）调用doDispatch（）进行处理,在doDispatch中才正式开始处理   
#####1.2doDispathch主要逻辑
	//检查是否是上传请求
	processedRequest = checkMultipart(request);
	//是上传请求的话标记，最后清除临时文件
	multipartRequestParsed = (processedRequest != request);
	//根据request 获取HandlerExecutionChain,获取执行链，里面包括HandlerInterceptor和Handler
	HandlerExecutionChain mappedHandler = getHandler(processedRequest);
	//根据HandlerExecutionChain中的Handler去获取执行Handler的HandlerAdapter
	HandlerAdapter ha = getHandlerAdapter(mappedHandler.getHandler());
    //在执行handler之前，先执行拦截器的前置方法
	if (!mappedHandler.applyPreHandle(processedRequest, response)) {
		return;
	}
    //在使用HandlerAdapter去执行handler(即执行controller，好像是更具反射执行)
	mv = ha.handle(processedRequest, response, mappedHandler.getHandler());
    //判断是否是异步 ，异步直接终止
	if (asyncManager.isConcurrentHandlingStarted()) {
		return;
	}
    //获取view的name
	applyDefaultViewName(processedRequest, mv);
	//拦截器的后置方法
	mappedHandler.applyPostHandle(processedRequest, response, mv);
	//根据viewResover找打View，使用 Model渲染View
	processDispatchResult(processedRequest, response, mappedHandler, mv, dispatchException);
    
	......(异常处理)

	//拦截器在整个请求完成后执行
	if (mappedHandler != null) {
		mappedHandler.applyAfterConcurrentHandlingStarted(processedRequest, response);
	}
	// 清除请求中的附件
	if (multipartRequestParsed) {
		cleanupMultipart(processedRequest);
	}

####2.主要类说明
#####2.1拦截器：HandlerInterceptor
     preHandler() - 在实际的handler被执行前被调用
     postHandler() - 在handler被执行后被调用
     afterCompletion() - 当request处理完成后被调用
**handler即自己写的Controller**

       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       