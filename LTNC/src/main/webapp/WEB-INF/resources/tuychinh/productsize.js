$(document).ready(function () {
    var dataSource = new kendo.data.DataSource({
        transport: {
            read: {
                url: "/LTNC/api/product-size/getall",
                type: "get",
                dataType: 'json'
            },
            create: {
                url: "/LTNC/api/product-size/create",
                type: "post",
                dataType: 'json',
                contentType: "application/json"
            },
            update: {
                url: "/LTNC/api/product-size/update",
                type: 'post',
                dataType: 'json',
                contentType: "application/json"
            },
            destroy: {
                url: "/LTNC/api/product-size/delete",
                type: 'post',
                dataType: "json",
                contentType: "application/json"
            },
            parameterMap: function (data, type) {
                if (type !== "read") {
                    if (type === "create") {
                    	var arr={
                    			productSizeName:data.models[0].productSizeName,
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
                id: "productSizeId",
                fields: {
                	productSizeId: { type: "number" },
                	productSizeName: { type: "string" }
                }
            }
        }
    });
    var grid = $("#grid-size").kendoGrid({
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
                {
                    field: "productSizeName", title: "Tên Size", width: 400,
                },
                { command: [{ name: "destroy", text: "Xóa" },{ name: "edit", text: "Sửa" }], title: "Thao Tác", width: 120 }
        ],
        editable: {
            confirmation: "Bạn có chắc chắn muốn xóa bản ghi này ?",
            confirmDelete: "Yes",
            mode:"inline"
        }
    });
});