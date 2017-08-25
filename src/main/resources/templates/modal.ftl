<!doctype html>
<html>
<head>
<#include "lib.ftl">
</head>
<body>
	          <form action="modal" class="form" modelAttribute="word" method="POST">
	               <div class="group-inline col-md-12">
	                         <input type="hidden" name="id" value="${id}">
	                    <div class="col-md-3">
	                         <label>Word</label>
	                          <input type="text" name="name" placeholder="Enter word" value="${word.name}" class="form-control">
	                    </div>
	                    <div class="col-md-3">
	                         <label>Mean</label>
	                         <input type="text" name="mean" placeholder="Enter meaning" value="${word.mean}" class="form-control">
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
	               </div>
	               <div class="form-group col-md-12" style="padding-top: 2em">
	                    <div class="col-md-4"></div>
	                    <div class="col-md-4 text-center">
	                          <input type="submit" class="btn btn-success" value="Save">
	                    </div>
	                    <div class="col-md-4"></div>
	               </div>
	          </form>
</body>
</html>