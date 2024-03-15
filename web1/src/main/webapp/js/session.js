// 세션값 저장 클릭 시 sessionSet.jsp 이동
const button1 = document.querySelector('div button:nth-child(1)');
const button2 = document.querySelector('div button:nth-child(2)');
const button3 = document.querySelector('div button:nth-child(3)');

// 자바 스크립트에서 이동시키는 것은 location.href
button1.addEventListener('click', () => {
  location.href = 'sessionSet.jsp';
});
// 세션값 삭제 클릭 시 sessionDel.jsp 이동
button2.addEventListener('click', () => {
  location.href = 'sessionDel.jsp';
});
// 세션값 초기화 클릭 시 이동
button3.addEventListener('click', () => {
  location.href = 'sessionInv.jsp';
});
