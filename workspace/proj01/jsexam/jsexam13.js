const person = {
    name: "carami",
    job: {
        title: "student",
        manager: {
            name: "kang",
        },
    },
};

function printmanagerName(person) {
    person.name ??= "jiyun";
    person.job ??= {}; // job 객체 초기화
    person.job.title ??= "student";
    person.job.manager ??= {}; // manager 객체 초기화
    person.job.manager.name ??= "hwang";

    person.name ||= "jiyun";
    person.job.title ||= "student";
    person.job.manager.name ||= "hwang";

    console.log(person);

    // console.log(person && person.job && person.job.manager && person.job.manager.name);
}

printmanagerName(person); // { name: "carami", job: { title: "student", manager: { name: "kang" } } }
printmanagerName({ name: 'kim' }); // { name: "kim", job: { title: "student", manager: { name: "hwang" } } }
printmanagerName({}); // { name: "jiyun", job: { title: "student", manager: { name: "hwang" } } }

const hwang = {
    name: "hwang",
    admin() {
        console.log("관리자 입니다.")
    },
};

const ji = {
    name: "jiyun"
};

//?.()있을 때만 호출
hwang.admin?.();
ji.admin?.(); //없어서 호출 안함

//?.[]
console.log(hwang?.["age"]);
const yun = {};
console.log(yun?.["name"]);