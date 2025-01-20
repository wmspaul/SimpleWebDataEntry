var offset = 0;
var finalDataEntry;
var lastDataPull;

function buildHeadings(obj) {
    const keys = Object.keys(obj);
    return keys.map(key => '<th>' + key.toUpperCase() + '</th>').join('');
}

function buildCell(cell) {
    return `<td>${cell}</td>`;
}

function buildRow(obj) {
    const values = Object.values(obj);
    return `<tr>${values.map(buildCell).join('')}</tr>`;
}

function buildRows(data) {
    return data.map(buildRow).join('');
}

function buildTable(data) {
    var htmlReturn = `
        <div class="table-data-entry">
            <div class="header">Simple Web Data Entry</div>
            <table cellspacing="0">
                <thead>${buildHeadings(data[0])}</thead>
                <tbody>${buildRows(data)}</tbody>
            </table>
        </div>
    ` +
    (offset != 0 ? `<button class="btn btn-primary btn-ghost" style="margin-left: 15px;" onclick="lastPageViewed()">Last</button>` : '') +
    (data.length == 10 && finalDataEntry != data[data.length - 1] ? `<button class="nextPageBtn btn btn-primary btn-ghost" style="margin-left: 15px;" onclick="nextPageToView()">Next</button>` : '');

    if (finalDataEntry != data[data.length - 1]) {
        finalDataEntry = data[data.length - 1];
    }

    return htmlReturn;
}

function nextPageToView() {
    offset++;
    refreshTable();
}

function lastPageViewed() {
    offset--;
    refreshTable();
}

const tableDataEntryContainer = document.querySelector('.table-data-entry-container');

function refreshTable() {
    $.get("/simple-web-data-entry/data", {offset: offset}, function(data) {
        const jsonObject = JSON.parse(data);
        var results = jsonObject['results'];
        if (results == null || results.length == 0) {
            if (offset != 0) {
                offset--;
            }
            results = lastDataPull;
        }
        lastDataPull = results;
        if (results !== null && results.length > 0) {
            const table = buildTable(results);
            tableDataEntryContainer.innerHTML = table;
            tableDataEntryContainer.style.visibility = "visible";
            tableDataEntryContainer.style.zIndex = "10";
        }
    });
}

$(document).ready(function() {
    $(".form-data-entry").submit(function(event) {
        event.preventDefault();

        var formData = $(this).serialize();
        if (!validateStringField($("#name").val())) {
            alert("Invalid name specified. Unsupported character!");
            return;
        }

        if (!isNumber($("#age").val())) {
            alert("Invalid age specified. Unsupported character!");
            return;
        }

        if ($("#title").val().length > 0 && !validateStringField($("#title").val())) {
            alert("Invalid title specified. Unsupported character!");
            return;
        }

        if ($("#hometown").val().length > 0 && !validateStringField($("#hometown").val())) {
            alert("Invalid hometown specified. Unsupported character!");
            return;
        }

        $.post("/simple-web-data-entry/data", formData, function(response) {
            $(".form-data-entry").hide();
            $(".form-data-entry").css("z-index", "20");
            refreshTable();
        });
    });
});

function validateStringField(name) {
    const nameRegex = /^[a-zA-Z\s'-\\.,]+$/;
    return nameRegex.test(name);
}

function isNumber(value) {
    const num = Number(value);
    return typeof num === 'number' && !isNaN(num);
}
