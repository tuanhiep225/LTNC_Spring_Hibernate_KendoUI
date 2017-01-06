$(document).ready(function () {
	var arrCategoryParent=[];
	var dataSourceCategoryParent=new kendo.data.DataSource({
		transport: {
            read: {
                url: "/LTNC/api/category/getListParent",
                type: "get",
                dataType: 'json'
            }
	},
	schema: {
        type: 'json',
        data: 'data',
        total: "itemCount",
        model: {
            id: "categoryId",
            fields: {
            	categoryId: { type: "number" },
            	categoryName: { type: "string" }
            }
        }
    }
	});
	dataSourceCategoryParent.fetch(function(){
		var data = this.data();
		for (var i = 0; i < data.length; i++) {
			arrCategoryParent.push({
                value: data[i].categoryId,
                text: data[i].categoryName
            })
        };
        var dataSource = new kendo.data.DataSource({
            transport: {
                read: {
                    url: "/LTNC/api/category/getall",
                    type: "get",
                    dataType: 'json'
                },
                create: {
                    url: "/LTNC/api/category/create",
                    type: "post",
                    dataType: 'json',
                    contentType: "application/json"
                },
                update: {
                    url: "/LTNC/api/category/update",
                    type: 'post',
                    dataType: 'json',
                    contentType: "application/json"
                },
                destroy: {
                    url: "/LTNC/api/category/delete",
                    type: 'post',
                    dataType: "json",
                    contentType: "application/json",
                    complete:function(e){
                    	$("#grid-category").data("kendoGrid").dataSource.read();
                    }
                },
                parameterMap: function (data, type) {
                    if (type !== "read") {
                        if (type === "create") {
                        	var arr={
                        			categoryName:data.models[0].categoryName,
                        			categoryParent:data.models[0].categoryParent,
                        			isActive:true
                        	}
                            return  kendo.stringify(arr)
                        }
                        return kendo.stringify(data.models[0])
                    }
                }
            },
            batch: true,
            pageSize: 20,
            schema: {
                type: 'json',
                data: 'data',
                total: "itemCount",
                model: {
                    id: "categoryId",
                    fields: {
                    	categoryId: { type: "number" },
                    	categoryName: { type: "string" },
                    	categoryParent: { type: "number" }
                    }
                }
            }
        });
        var grid = $("#grid-category").kendoGrid({
            dataSource: dataSource,
            height: window.innerHeight * 0.8,
            sortable: true,
            columnMenu: {
                messages: {
                    columns: "Chọn cột",
                    filter: "Lọc",
                    sortAscending: "Tăng dần",
                    sortDescending: "Giảm dần",
                }
            },
            pageable: {
                pageSize: 50,
                pageSizes: true,
                refresh: true,
                messages: {
                    display: "{0} - {1} của {2} kết quả",
                    empty: "Không có kết quả nào",
                    page: "trang",
                    of: "của {0}",
                    itemsPerPage: "kết quả/trang",
                    first: "Về trang đầu",
                    previous: "Về trang trước",
                    next: "Về trang tiếp theo",
                    last: "Về trang cuối",
                    refresh: "Làm mới",
                    allPages: "Tất"
                }
            },
            filterable: {
                mode: "row",
                messages: {
                    and: "và",
                    or: "hoặc"
                },
                operators: {
                    string: {
                        contains: "Chứa từ khóa",
                        doesnotcontain: "Không chứa từ khóa này",
                        endswith: "Kết thúc với từ khóa này",
                        eq: "So sánh bằng",
                        isempty: "Từ khóa rỗng",
                        isnotempty: "Không trống",
                        neq: "Không bằng",
                        startswith: "Bắt đầu với từ khóa này"
                    }

                }
            },
            resizable: true,
            toolbar: [{ name: "create", text: "Thêm Mới" }, { name: "excel", text: "Xuất Excel" }],
            columns: [
                    { command: [{ name: "destroy", text: "Xóa" },{ name: "edit", text: "Sửa" }], title: "Thao Tác", width: 120 },
                    {
                        field: "categoryName", title: "Tên Danh Mục", width: 200,
                    },
                    {
                        field: "categoryParent", title: "Danh Mục Cha",values:arrCategoryParent, width: 200,
                    }
            ],
            editable: {
                confirmation: "Bạn có chắc chắn muốn xóa bản ghi này ?",
                confirmDelete: "Yes",
                mode:"inline"
            }
        });
	});   
});