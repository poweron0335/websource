// 폼이 비어 있는지 확인

const form = document.querySelector('form');

form.addEventListener('submit', (e) => {
  e.preventDefault();

  const name = document.querySelector('#name');
  const title = document.querySelector('#title');
  const content = document.querySelector('#content');
  const password = document.querySelector('#password');

  if (!name.value) {
    alert('이름이 비어있습니다. 입력해주세요');
    name.focus();
    return;
  } else if (!title.value) {
    alert('제목이 비어있습니다. 입력해주세요');
    title.focus();
    return;
  } else if (!content.value) {
    alert('내용이 비어있습니다. 입력해주세요');
    content.focus();
    return;
  } else if (!password.value) {
    alert('비밀번호를 입력하십시오');
    password.focus();
    return;
  }
  form.submit();
});

document.querySelector('#list').addEventListener('click', () => {
  location.href = '/qList.do';
});
