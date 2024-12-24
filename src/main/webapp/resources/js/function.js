
function deleteStudents(){
    var checkedCheckboxs = document.querySelectorAll('input[name=idStudent]:checked')
    if(checkedCheckboxs.length == 0){
        alert("Выберите хотя бы одного студента!!!")
        return;
    }

    // 1-2-5-7 - string
    var ids = ""
    for(var i = 0; i < checkedCheckboxs.length; i++){
        ids = ids + checkedCheckboxs[i].value + " ";
    }

    document.getElementById("deleteStudentHidden").value = ids;
    document.getElementById('deleteStudentForm').submit();


}


function studentProgress(){
    var checkedCheckboxs = document.querySelectorAll('input[name=idStudent]:checked')
    if(checkedCheckboxs.length == 0){
        alert("Выберите хотя бы одного студента!!!")
        return;
    }
    if(checkedCheckboxs.length > 1){
        alert("Выберите только одного студента!!!")
        return;
    }


    document.getElementById("studentProgressHidden").value = checkedCheckboxs[0].value;
    document.getElementById('studentProgressForm').submit();


}


function deleteDiscipline(){
    var checkedCheckboxs = document.querySelectorAll('input[name=idDiscipline]:checked')
    if(checkedCheckboxs.length == 0){
        alert("Выберите хотя бы одного студента!!!")
        return;
    }

    // 1-2-5-7 - string
    var iddisc = ""
    for(var i = 0; i < checkedCheckboxs.length; i++){
        iddisc = iddisc + checkedCheckboxs[i].value + " ";
    }

    document.getElementById("deleteDisciplineHidden").value = iddisc;
    document.getElementById('deleteDisciplineForm').submit();


}
// function setSelectedStudentId() {
//     var checkedCheckboxs = document.querySelectorAll('input[name=idStudent]:checked');
//
//     if (checkedCheckboxs.length == 0) {
//         alert("Выберите хотя бы одного студента!!!")
//         return;
//     }
//     if (checkedCheckboxs.length > 1) {
//         alert("Выберите только одного студента!!!")
//         return;
//     }
//     document.getElementById("selectedStudentIdHidden").value = checkedCheckboxs[0].value;
//     document.getElementById('selectedStudentIdForm').submit();
// }
function modifyStudent() {
    var checkedCheckboxes = document.querySelectorAll('input[type=checkbox]:checked');

    if (checkedCheckboxes.length === 0) {
        alert("Пожалуйста, выберите хотя бы одного студента!!!");
        return;
    }

    if (checkedCheckboxes.length > 1) {
        alert("Пожалуйста, выберите только одного студента!");
        return;
    }

    var idSelected = checkedCheckboxes[0].value;

    document.getElementById("selectedStudentIdHidden").value = idSelected;
    document.getElementById('selectedStudentIdForm').submit();
}


function modifyDiscipline() {
    var checkedCheckboxes = document.querySelectorAll('input[type=checkbox]:checked');

    if (checkedCheckboxes.length === 0) {
        alert("Пожалуйста, выберите хотя бы одну дисциплину!!!");
        return;
    }

    if (checkedCheckboxes.length > 1) {
        alert("Пожалуйста, выберите только одну дисциплину!");
        return;
    }

    var idSelected = checkedCheckboxes[0].value;

    document.getElementById("modifyId").value = idSelected;
    document.getElementById('disciplineModifyForm').submit();
}


