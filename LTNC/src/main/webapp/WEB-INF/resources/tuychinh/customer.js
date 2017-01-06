var quyen=[
	{text:"Admin",value:1},
	{text:"Khách",value:2}
]
$(document).ready(function () {
    var dataSource = new kendo.data.DataSource({
        transport: {
            read: {
                url: "/LTNC/api/customer/getall",
                type: "get",
                dataType: 'json'
            },
            create: {
                url: "/LTNC/api/customer/create",
                type: "post",
                dataType: 'json',
                contentType: "application/json"
            },
            update: {
                url: "/LTNC/api/customer/update",
                type: 'post',
                dataType: 'json',
                contentType: "application/json"
            },
            destroy: {
                url: "/LTNC/api/customer/delete",
                type: 'post',
                dataType: "json",
                contentType: "application/json"
            },
            parameterMap: function (data, type) {
                if (type !== "read") {
                    if (type === "create") {
                    	var arr={
                    			name:data.models[0].name,
                    			account:data.models[0].account,
                    			address:data.models[0].address,
                    			phone:data.models[0].phone,
                    			email:data.models[0].email,
                    			role:data.models[0].role,
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
                id: "customerId",
                fields: {
                	customerId: { type: "number" },
                	account:{type:"string"},
                	address:{type:"string"},
                	email: { type: "string" },
                	phone: { type: "string" },
                	role: { type: "number" ,defaultValue:2}
                }
            }
        }
    });
    var grid = $("#grid-customer").kendoGrid({
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
                { command: [{ name: "destroy", text: "Xóa" },{ name: "edit", text: "Sửa" }], title: "Thao Tác", width: 250 },
                {
                    field: "name", title: "Tên Khách Hàng", width: 200,
                },
                {
                    field: "account", title: "Tài Khoản", width: 175,
                },
                {
                    field: "address", title: "Địa Chỉ", width: 175,
                },
                {
                    field: "email", title: "Email", width: 175,
                },
                {
                    field: "phone", title: "Số Điện Thoại", width: 175,
                },
                {
                    field: "role", title: "Quyền", width: 175,values:quyen
                }
        ],
        editable: {
            confirmation: "Bạn có chắc chắn muốn xóa bản ghi này ?",
            confirmDelete: "Yes",
            mode:"inline"
        }
    });
});