<!doctype html>
<html>
<head>
    <#include "lib.ftl">
	<meta charset="UTF-8">
	<title>Spring Community</title>
</head>
<body>
    <div class="jumbotron text-center">
			<h2>English Vietnamese Dictionary</h2>
			<p>CRUD application with JDBC Data API, Freemarker in Spring</p>
	</div>
	<div class="container">
	    <div class="row search">
	         <form action="search" method="get">
	               <div class="form-group">
	                     <div class="col-md-4">
	                           <input type="text" name="key" class="form-control" placeholder="Enter keyword">
	                     </div>
	                     <div class="col-md-4">
	                            <input type="submit" class="form-control btn btn-default" value="Search" />
	                     </div>
	                     <div class="col-md-4 text-center">
	                         <#if row == 1 >
	                            <p>There are <span class="badge">${row}</span> word in System</p>
	                         <#elseif (row > 1)>  
	                            <p> There are <span class="badge">${row}</span> words in System</p> 
	                         <#else>
	                              <p> There are no words in System</p>
	                         </#if>
	                     </div>
	               </div>
	         </form>
	    </div>
	    <div class="row filter">
	          <form method="POST">
	                <div class="form-group">
	                     <!----------- categories---------->
	                          <div class="col-md-4">
	                                  <select class="form-control" name="categoryId">
	                                                     <option value="0" selected>Filter by category</option>
	                                         <#if categories?has_content>
	                                               <#list categories as category>
	                                                     <option value="${category.id}">${category.category}</option>
	                                               </#list>
	                                         </#if>
	                                  </select>
	                          </div><!--category select-->
	                      <!----------- types---------->
	                     <div class="col-md-4">
	                           <select class="form-control" name="typeId">
	                                              <option value="0" selected>Filter by type</option>
	                                  <#if types?has_content>
	                                        <#list types as type>
	                                              <option value="${type.id}">${type.type}</option>
	                                        </#list>
	                                  </#if>
	                           </select>
	                     </div><!--type select-->
	                     
	                     <div class="col-md-4">
	                           <input type="submit" class="form-control btn btn-default" value="Sort" />
	                     </div><!--category select-->
	                </div><!--form-group filter-->

	          </form> 
	    </div>
	    <form action="action" method="POST">
	          <table class="table bodered">
	              <thead>
	                   <tr>
	                       <th></th>
	                       <th>English</th>
	                       <th>Type</th>
	                       <th>Vietnamese</th>
	                       <th class="text-center">Action</th>
	                   </tr>
	              </thead>
	              <tbody>
	                   <#if words?has_content>
	                        <#list words as word>
	                              <tr>
	                                 <td><input type="radio" value="${word.id}" name="wordId" /></td>
	                                 <td>${word.name}</td>
	                                 <td>${typeHashMap[word.typeId+""].type}</td>
	                                 <td>${word.mean}</td>
	                                 <td>
	                                       <div class="form-group col-md-12">
	                                             <div class="col-md-4">
	                                                   <input type="button" class="form-control btn btn-default" value="Create" />
	                                             </div>
	                                             <div class="col-md-4">
	                                                  <input type="submit"  class="form-control btn btn-primary" name="action" value="Edit" />
	                                             </div>
	                                             <div class="col-md-4">
	                                                  <input type="submit" name="action" class="form-control btn btn-warning" value="Delete" />
	                                             </div>
	                                      </div>
	                                    </td>
	                                 </tr>
	                        </#list>
	                   </#if>
	              <tbody>
	                                 <tr>
	                                      <td>
	                                      <ul class="pagination">
	                                          <li><a href="#">1</a></li>
                                              <li><a href="#">2</a></li>
                                              <li><a href="#">3</a></li>
                                              <li><a href="#">4</a></li>
                                              <li><a href="#">5</a></li>
	                                      </ul>
	                                      </td>
	                                 </tr>
	          </table>
	    </form>      
	    <div class="row words">
	    </div>
	    <div class="row newword" style="display: ;">
	          <form class="form" action="insert" modelAttribute="newword" method="POST">
	               <div class="group-inline col-md-12">
	                    <div class="col-md-3">
	                         <label>Word</label>
	                          <input type="text" name="name" placeholder="Enter new word" value="" class="form-control">
	                    </div>
	                    <div class="col-md-3">
	                         <label>Mean</label>
	                          <input type="text" name="mean" placeholder="Enter new word" value="" class="form-control">
	                    </div>
	                    <div class="col-md-3">
	                           <label>Type</label>
	                           <select class="form-control" name="typeId">
	                                  <#if types?has_content>
	                                        <#list types as type>
	                                              <option value="${type.id}">${type.type}</option>
	                                        </#list>
	                                  </#if>
	                           </select>
	                    </div>
	                    <div class="col-md-3 text-center">
	                             <label>Add</label>
	                             <input type="button" value="+" class="form-control btn btn-primary">
	                    </div>
	               </div>
	               <div class="form-group col-md-12" style="padding-top: 2em">
	                    <div class="col-md-4"></div>
	                    <div class="col-md-4 text-center">
	                          <input type="submit" class="btn btn-success" value="Save">
	                    </div>
	                    <div class="col-md-4"></div>
	               </div>
	          </form>
	    </div>
	</div>
</body>
<script   src="https://code.jquery.com/jquery-1.12.4.js"></script> 
<script>
    $(function(event){
             $(".newword").css("display","none");
         $(':input[value="Create"]').click(function(){
             $(".newword").toggle();
         });
         $(':input[value="+"]').click(function(){
         
         });
    })
</script>
</html>