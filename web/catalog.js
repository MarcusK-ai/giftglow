export const apps = [
  {id:'gifts',name:'Giftglow',tagline:'Keep gift ideas before you forget.',icon:'✧',color:'#e7b2fb',type:'checklist',unit:'gift idea',fields:[['name','Gift idea','text'],['detail','Person / occasion / shop','text'],['amount','Budget','number']],hint:'Gift ideas',empty:'Save a thoughtful idea as soon as it occurs to you.'}
];
export function appById(id){return apps.find(app=>app.id===id)}
