// submit 발생 시
// submit 기능 중지
// code, title 비어 있는지 확인
// code : 4자리인지 확인까지
// criteria, keyword 비어 있는지 확인
// 값이 존재한다면 submit

const form = document.querySelector('form');
form.addEventListener('submit', (e) => {
  e.preventDefault();

  const criteria = document.querySelector('#criteria');
  const keyword = document.querySelector('#keyword');

  // selected 의 값을 찾아올 땐 console.log 를 활용해 무슨 값을 가져오는 지 확인해보자

  if (criteria.value == '검색 조건 선택') {
    alert('조건을 선택해주세요');
    criteria.focus();
    return;
  } else if (!keyword.value) {
    alert('keyword 값이 비어 있습니다.');
    keyword.focus();
    return;
  }
  form.submit();
});
