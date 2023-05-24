var app=function(){"use strict";function t(){}function e(t){return t()}function n(){return Object.create(null)}function s(t){t.forEach(e)}function o(t){return"function"==typeof t}function i(t,e){return t!=t?e==e:t!==e||t&&"object"==typeof t||"function"==typeof t}let l,c;function a(t,e){t.appendChild(e)}function r(t,e,n){t.insertBefore(e,n||null)}function u(t){t.parentNode&&t.parentNode.removeChild(t)}function d(t){return document.createElement(t)}function p(t){return document.createTextNode(t)}function f(){return p(" ")}function g(t,e,n,s){return t.addEventListener(e,n,s),()=>t.removeEventListener(e,n,s)}function m(t,e,n){null==n?t.removeAttribute(e):t.getAttribute(e)!==n&&t.setAttribute(e,n)}function h(t){return""===t?null:+t}function v(t,e){t.value=null==e?"":e}function x(t,e){return new t(e)}function $(t){c=t}const b=[],y=[];let k=[];const w=[],S=Promise.resolve();let C=!1;function I(t){k.push(t)}const _=new Set;let L=0;function E(){if(0!==L)return;const t=c;do{try{for(;L<b.length;){const t=b[L];L++,$(t),T(t.$$)}}catch(t){throw b.length=0,L=0,t}for($(null),b.length=0,L=0;y.length;)y.pop()();for(let t=0;t<k.length;t+=1){const e=k[t];_.has(e)||(_.add(e),e())}k.length=0}while(b.length);for(;w.length;)w.pop()();C=!1,_.clear(),$(t)}function T(t){if(null!==t.fragment){t.update(),s(t.before_update);const e=t.dirty;t.dirty=[-1],t.fragment&&t.fragment.p(t.ctx,e),t.after_update.forEach(I)}}const q=new Set;let A;function D(){A={r:0,c:[],p:A}}function N(){A.r||s(A.c),A=A.p}function M(t,e){t&&t.i&&(q.delete(t),t.i(e))}function V(t,e,n,s){if(t&&t.o){if(q.has(t))return;q.add(t),A.c.push((()=>{q.delete(t),s&&(n&&t.d(1),s())})),t.o(e)}else s&&s()}function z(t){t&&t.c()}function B(t,n,i,l){const{fragment:c,after_update:a}=t.$$;c&&c.m(n,i),l||I((()=>{const n=t.$$.on_mount.map(e).filter(o);t.$$.on_destroy?t.$$.on_destroy.push(...n):s(n),t.$$.on_mount=[]})),a.forEach(I)}function H(t,e){const n=t.$$;null!==n.fragment&&(!function(t){const e=[],n=[];k.forEach((s=>-1===t.indexOf(s)?e.push(s):n.push(s))),n.forEach((t=>t())),k=e}(n.after_update),s(n.on_destroy),n.fragment&&n.fragment.d(e),n.on_destroy=n.fragment=null,n.ctx=[])}function O(t,e){-1===t.$$.dirty[0]&&(b.push(t),C||(C=!0,S.then(E)),t.$$.dirty.fill(0)),t.$$.dirty[e/31|0]|=1<<e%31}function P(e,o,i,l,a,r,d,p=[-1]){const f=c;$(e);const g=e.$$={fragment:null,ctx:[],props:r,update:t,not_equal:a,bound:n(),on_mount:[],on_destroy:[],on_disconnect:[],before_update:[],after_update:[],context:new Map(o.context||(f?f.$$.context:[])),callbacks:n(),dirty:p,skip_bound:!1,root:o.target||f.$$.root};d&&d(g.root);let m=!1;if(g.ctx=i?i(e,o.props||{},((t,n,...s)=>{const o=s.length?s[0]:n;return g.ctx&&a(g.ctx[t],g.ctx[t]=o)&&(!g.skip_bound&&g.bound[t]&&g.bound[t](o),m&&O(e,t)),n})):[],g.update(),m=!0,s(g.before_update),g.fragment=!!l&&l(g.ctx),o.target){if(o.hydrate){const t=function(t){return Array.from(t.childNodes)}(o.target);g.fragment&&g.fragment.l(t),t.forEach(u)}else g.fragment&&g.fragment.c();o.intro&&M(e.$$.fragment),B(e,o.target,o.anchor,o.customElement),E()}$(f)}class j{$destroy(){H(this,1),this.$destroy=t}$on(e,n){if(!o(n))return t;const s=this.$$.callbacks[e]||(this.$$.callbacks[e]=[]);return s.push(n),()=>{const t=s.indexOf(n);-1!==t&&s.splice(t,1)}}$set(t){var e;this.$$set&&(e=t,0!==Object.keys(e).length)&&(this.$$.skip_bound=!0,this.$$set(t),this.$$.skip_bound=!1)}}function F(t){let e;return{c(){e=d("p"),e.textContent="Invalid email",m(e,"class","validation-error svelte-2e1pxb")},m(t,n){r(t,e,n)},d(t){t&&u(e)}}}function W(t){let e;return{c(){e=d("p"),e.textContent="Valid email",m(e,"class","validation svelte-2e1pxb")},m(t,n){r(t,e,n)},d(t){t&&u(e)}}}function Z(t){let e;return{c(){e=d("p"),e.textContent="Please enter a longer password",m(e,"class","validation-error svelte-2e1pxb")},m(t,n){r(t,e,n)},d(t){t&&u(e)}}}function G(t){let e;return{c(){e=d("p"),e.textContent="Password is save.",m(e,"class","validation svelte-2e1pxb")},m(t,n){r(t,e,n)},d(t){t&&u(e)}}}function R(e){let n,o,i,l,c,p,h,x,$,b,y,k,w,S,C,I,_=e[2]&&!e[4]&&F(),L=e[4]&&W(),E=e[2]&&!e[3]&&Z(),T=e[3]&&G();return{c(){n=d("div"),o=d("h1"),o.textContent="Login",i=f(),l=d("div"),c=d("input"),p=f(),_&&_.c(),h=f(),L&&L.c(),x=f(),$=d("div"),b=d("input"),y=f(),E&&E.c(),k=f(),T&&T.c(),w=f(),S=d("button"),S.textContent="Login",m(o,"class","svelte-2e1pxb"),m(c,"class","eingabe"),m(c,"type","email"),m(c,"placeholder","Email"),m(l,"class","input-wrapper svelte-2e1pxb"),m(b,"class","eingabe"),m(b,"type","password"),m(b,"placeholder","Password"),m($,"class","input-wrapper svelte-2e1pxb"),m(S,"class","btnSubmit"),m(n,"class","textField")},m(t,s){r(t,n,s),a(n,o),a(n,i),a(n,l),a(l,c),v(c,e[0]),a(l,p),_&&_.m(l,null),a(l,h),L&&L.m(l,null),a(n,x),a(n,$),a($,b),v(b,e[1]),a($,y),E&&E.m($,null),a($,k),T&&T.m($,null),a(n,w),a(n,S),C||(I=[g(c,"input",e[6]),g(b,"input",e[7]),g(S,"click",e[5])],C=!0)},p(t,[e]){1&e&&c.value!==t[0]&&v(c,t[0]),t[2]&&!t[4]?_||(_=F(),_.c(),_.m(l,h)):_&&(_.d(1),_=null),t[4]?L||(L=W(),L.c(),L.m(l,null)):L&&(L.d(1),L=null),2&e&&b.value!==t[1]&&v(b,t[1]),t[2]&&!t[3]?E||(E=Z(),E.c(),E.m($,k)):E&&(E.d(1),E=null),t[3]?T||(T=G(),T.c(),T.m($,null)):T&&(T.d(1),T=null)},i:t,o:t,d(t){t&&u(n),_&&_.d(),L&&L.d(),E&&E.d(),T&&T.d(),C=!1,s(I)}}}function U(t,e,n){let s,o,i="",l="",c=!1;return t.$$.update=()=>{1&t.$$.dirty&&n(4,s=function(t){return/^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/.test(String(t).toLowerCase())}(i)),2&t.$$.dirty&&n(3,o=l.length>=4)},[i,l,c,o,s,function(){n(2,c=!0),s&&o&&alert("submitted")},function(){i=this.value,n(0,i)},function(){l=this.value,n(1,l)}]}class J extends j{constructor(t){super(),P(this,t,U,R,i,{})}}function K(e){let n,o,i,l,c,h,x,$,b,y,k,w,S,C,I,_,L,E,T,q,A,D,N,M,V,z,B,H,O,P,j,F,W;return{c(){n=d("div"),o=d("div"),i=d("div"),l=d("h1"),l.textContent="WLAN-Hotspot",c=f(),h=d("label"),x=d("input"),$=f(),b=d("span"),y=f(),k=d("div"),w=d("h1"),w.textContent="Bestehendes WLAN",S=f(),C=d("p"),C.textContent="SSID",I=f(),_=d("input"),E=f(),T=d("p"),T.textContent="Passwort",q=f(),A=d("input"),N=f(),M=d("button"),V=p("Verbinden"),B=f(),H=d("div"),O=d("h1"),O.textContent="Eigene SSID",P=f(),j=d("input"),m(x,"id","hotspot"),m(x,"type","checkbox"),m(x,"class","svelte-qmlksk"),m(b,"class","slider round svelte-qmlksk"),m(h,"class","switch svelte-qmlksk"),m(i,"class","container1 svelte-qmlksk"),m(_,"class","eingabe"),m(_,"type","string"),m(_,"id","wlanSSID"),_.disabled=L=!e[1],m(A,"class","eingabe"),m(A,"type","string"),m(A,"id","wlanPasswort"),A.disabled=D=!e[1],m(M,"class","btnSubmit svelte-qmlksk"),m(M,"id","connect"),M.disabled=z=!e[1],m(k,"class","container1 svelte-qmlksk"),m(j,"class","eingabe"),m(j,"type","string"),m(j,"id","inputBtn"),m(j,"placeholder","Drehteller1"),m(H,"class","container1 svelte-qmlksk"),m(o,"class","container svelte-qmlksk"),m(n,"class","switchContainer svelte-qmlksk")},m(t,s){r(t,n,s),a(n,o),a(o,i),a(i,l),a(i,c),a(i,h),a(h,x),x.checked=e[1],a(h,$),a(h,b),a(o,y),a(o,k),a(k,w),a(k,S),a(k,C),a(k,I),a(k,_),v(_,e[2]),a(k,E),a(k,T),a(k,q),a(k,A),v(A,e[3]),a(k,N),a(k,M),a(M,V),a(o,B),a(o,H),a(H,O),a(H,P),a(H,j),v(j,e[0]),F||(W=[g(x,"change",e[5]),g(_,"input",e[4]),g(_,"input",e[6]),g(A,"input",e[4]),g(A,"input",e[7]),g(M,"click",Q),g(j,"input",e[4]),g(j,"input",e[8])],F=!0)},p(t,[e]){2&e&&(x.checked=t[1]),2&e&&L!==(L=!t[1])&&(_.disabled=L),4&e&&v(_,t[2]),2&e&&D!==(D=!t[1])&&(A.disabled=D),8&e&&v(A,t[3]),2&e&&z!==(z=!t[1])&&(M.disabled=z),1&e&&v(j,t[0])},i:t,o:t,d(t){t&&u(n),F=!1,s(W)}}}function Q(){}function X(t,e,n){let s="",o=!1,i="",l="";return[s,o,i,l,function(){console.log(s),console.log(i),console.log(l)},function(){o=this.checked,n(1,o)},function(){i=this.value,n(2,i)},function(){l=this.value,n(3,l)},function(){s=this.value,n(0,s)}]}class Y extends j{constructor(t){super(),P(this,t,X,K,i,{})}}function tt(e){let n,o,i,l,c,p,x,$;return{c(){n=d("div"),o=d("h1"),o.textContent="Umschaltgeschwindigkeit",i=f(),l=d("input"),c=f(),p=d("input"),m(l,"step","1"),m(l,"type","range"),m(l,"min","2"),m(l,"max","10"),m(l,"class","slider svelte-68hx69"),m(l,"id","myRange"),m(p,"class","eingabe svelte-68hx69"),m(p,"type","number"),m(p,"id","numField"),m(p,"min","0"),m(p,"max","100"),m(n,"class","slidecontainer svelte-68hx69")},m(t,s){r(t,n,s),a(n,o),a(n,i),a(n,l),v(l,e[0]),a(n,c),a(n,p),v(p,e[0]),x||($=[g(l,"change",e[3]),g(l,"input",e[3]),g(l,"change",e[2]),g(p,"input",e[4]),g(p,"input",e[1])],x=!0)},p(t,[e]){1&e&&v(l,t[0]),1&e&&h(p.value)!==t[0]&&v(p,t[0])},i:t,o:t,d(t){t&&u(n),x=!1,s($)}}}function et(t,e,n){let s=0;return null!=sessionStorage.getItem("displayVel")&&(s=sessionStorage.getItem("displayVel")),[s,function(t){const e=t.target.value;n(0,s=e<0?0:e>100?100:""===e?0:e)},function(){sessionStorage.setItem("displayVel",s),console.log(window.sessionStorage.getItem("displayVel"))},function(){s=h(this.value),n(0,s)},function(){s=h(this.value),n(0,s)}]}class nt extends j{constructor(t){super(),P(this,t,et,tt,i,{})}}function st(t){let e,n,o,i,l,c,h,x,$,b,y,k,w,S,C,I,_=t[0].length+"";return w=new nt({}),{c(){e=d("div"),n=d("h1"),n.textContent="Displaytext",o=f(),i=d("p"),i.textContent="Text darf nicht mehr als 160 Zeichen beinhalten.",l=f(),c=d("textarea"),h=f(),x=d("p"),$=p("Zeichen: "),b=d("span"),y=p(_),k=f(),z(w.$$.fragment),m(i,"class","svelte-1iqkhhz"),m(c,"class","eingabe"),m(c,"maxlength","160"),m(c,"rows","5"),m(c,"id","inputBtn"),m(b,"id","demo2"),m(x,"class","svelte-1iqkhhz"),m(e,"class","textField svelte-1iqkhhz")},m(s,u){r(s,e,u),a(e,n),a(e,o),a(e,i),a(e,l),a(e,c),v(c,t[0]),a(e,h),a(e,x),a(x,$),a(x,b),a(b,y),a(e,k),B(w,e,null),S=!0,C||(I=[g(c,"input",t[1]),g(c,"input",t[2])],C=!0)},p(t,[e]){1&e&&v(c,t[0]),(!S||1&e)&&_!==(_=t[0].length+"")&&function(t,e){e=""+e,t.wholeText!==e&&(t.data=e)}(y,_)},i(t){S||(M(w.$$.fragment,t),S=!0)},o(t){V(w.$$.fragment,t),S=!1},d(t){t&&u(e),H(w),C=!1,s(I)}}}function ot(t,e,n){let s,o="";function i(){s=document.getElementById("eingabeL")?.innerHTML.length,console.log(s),sessionStorage.setItem("displayText",o),console.log(window.sessionStorage.getItem("displayText"))}return null!=sessionStorage.getItem("displayText")&&(o=sessionStorage.getItem("displayText")),i(),[o,i,function(){o=this.value,n(0,o)}]}class it extends j{constructor(t){super(),P(this,t,ot,st,i,{})}}function lt(e){let n,o,i,l,c,p,x,$;return{c(){n=d("div"),o=d("h1"),o.textContent="LED-Helligkeit",i=f(),l=d("input"),c=f(),p=d("input"),m(l,"step","5"),m(l,"type","range"),m(l,"min","0"),m(l,"max","100"),m(l,"class","slider svelte-1t240kg"),m(l,"id","myRange"),m(p,"class","eingabe svelte-1t240kg"),m(p,"type","number"),m(p,"id","numField"),m(p,"min","0"),m(p,"max","100"),m(n,"class","slidecontainer svelte-1t240kg")},m(t,s){r(t,n,s),a(n,o),a(n,i),a(n,l),v(l,e[0]),a(n,c),a(n,p),v(p,e[0]),x||($=[g(l,"change",e[3]),g(l,"input",e[3]),g(l,"change",e[2]),g(p,"input",e[4]),g(p,"input",e[1])],x=!0)},p(t,[e]){1&e&&v(l,t[0]),1&e&&h(p.value)!==t[0]&&v(p,t[0])},i:t,o:t,d(t){t&&u(n),x=!1,s($)}}}function ct(t,e,n){let s=0;return null!=sessionStorage.getItem("led")&&(s=sessionStorage.getItem("led")),[s,function(t){const e=t.target.value;n(0,s=e<0?0:e>100?100:""===e?0:e)},function(){sessionStorage.setItem("led",s),console.log(window.sessionStorage.getItem("led"))},function(){s=h(this.value),n(0,s)},function(){s=h(this.value),n(0,s)}]}class at extends j{constructor(t){super(),P(this,t,ct,lt,i,{})}}function rt(e){let n,o,i,l,c,p,x,$;return{c(){n=d("div"),o=d("h1"),o.textContent="Motorgeschwindigkeit",i=f(),l=d("input"),c=f(),p=d("input"),m(l,"step","5"),m(l,"type","range"),m(l,"min","0"),m(l,"max","100"),m(l,"class","slider svelte-68hx69"),m(l,"id","myRange"),m(p,"class","eingabe svelte-68hx69"),m(p,"type","number"),m(p,"id","numField"),m(p,"min","0"),m(p,"max","100"),m(n,"class","slidecontainer svelte-68hx69")},m(t,s){r(t,n,s),a(n,o),a(n,i),a(n,l),v(l,e[0]),a(n,c),a(n,p),v(p,e[0]),x||($=[g(l,"change",e[3]),g(l,"input",e[3]),g(l,"change",e[1]),g(p,"input",e[4]),g(p,"input",e[2])],x=!0)},p(t,[e]){1&e&&v(l,t[0]),1&e&&h(p.value)!==t[0]&&v(p,t[0])},i:t,o:t,d(t){t&&u(n),x=!1,s($)}}}function ut(t,e,n){let s=0;function o(){sessionStorage.setItem("motor",s),console.log(window.sessionStorage.getItem("motor"))}return null!=sessionStorage.getItem("motor")&&(s=sessionStorage.getItem("motor")),[s,o,function(t){const e=t.target.value;n(0,s=e<0?0:e>100?100:""===e?0:e),o()},function(){s=h(this.value),n(0,s)},function(){s=h(this.value),n(0,s)}]}class dt extends j{constructor(t){super(),P(this,t,ut,rt,i,{})}}function pt(e){let n;return{c(){n=d("div"),n.innerHTML='<img src="logo_grey.svg" class="svelte-czrap2"/>',m(n,"class","svelte-czrap2")},m(t,e){r(t,n,e)},p:t,i:t,o:t,d(t){t&&u(n)}}}function ft(t){let e,n,s;var o=gt;return o&&(e=x(o,{})),{c(){e&&z(e.$$.fragment),n=p("")},m(t,o){e&&B(e,t,o),r(t,n,o),s=!0},p(t,[s]){if(o!==(o=gt)){if(e){D();const t=e;V(t.$$.fragment,1,0,(()=>{H(t,1)})),N()}o?(e=x(o,{}),z(e.$$.fragment),M(e.$$.fragment,1),B(e,n.parentNode,n)):e=null}},i(t){s||(e&&M(e.$$.fragment,t),s=!0)},o(t){e&&V(e.$$.fragment,t),s=!1},d(t){t&&u(n),e&&H(e,t)}}}let gt=class extends j{constructor(t){super(),P(this,t,null,pt,i,{})}};function mt(){gt=dt,console.log(gt.name)}function ht(){gt=at,console.log(gt.name)}function vt(){gt=it,console.log(gt.name)}function xt(){gt=nt,console.log(gt.name)}function $t(){gt=Y,console.log(gt.name)}function bt(){gt=J,console.log(gt.name)}class yt extends j{constructor(t){super(),P(this,t,null,ft,i,{})}}function kt(e){let n,s;return n=new yt({}),{c(){z(n.$$.fragment)},m(t,e){B(n,t,e),s=!0},p:t,i(t){s||(M(n.$$.fragment,t),s=!0)},o(t){V(n.$$.fragment,t),s=!1},d(t){H(n,t)}}}function wt(e){let n,o,c,p,h,v,x,$,b,y,k,w,S,C,I,_,L,E,T,q,A,z,B,H,O,P,j,F,W=e[0],Z=kt();return{c(){var t,e;n=d("div"),o=d("div"),c=d("div"),p=f(),h=d("div"),v=d("img"),$=f(),b=d("button"),b.textContent="Login",y=f(),k=d("div"),w=d("div"),S=d("button"),S.textContent="Motorgeschwindigkeit",C=f(),I=d("button"),I.textContent="LED",_=f(),L=d("button"),L.textContent="Displaytext",E=f(),T=d("button"),T.textContent="Umschaltgeschwindigkeit",q=f(),A=d("button"),A.textContent="WLAN-Modus",z=f(),B=d("button"),B.textContent="Submit",H=f(),O=d("div"),Z.c(),m(c,"class","blue svelte-1gpfft5"),t=v.src,e=x="HTL-Logo.png",l||(l=document.createElement("a")),l.href=e,t!==l.href&&m(v,"src","HTL-Logo.png"),m(v,"class","svelte-1gpfft5"),m(b,"class","btn"),m(h,"class","gray svelte-1gpfft5"),m(o,"class","header svelte-1gpfft5"),m(S,"class","btn"),m(I,"class","btn"),m(L,"class","btn"),m(T,"class","btn"),m(A,"class","btn"),m(B,"class","btnSubmit"),m(w,"class","container svelte-1gpfft5"),m(O,"class","container2 svelte-1gpfft5"),m(k,"class","containerBoth svelte-1gpfft5"),m(n,"class","containerAll")},m(t,s){r(t,n,s),a(n,o),a(o,c),a(o,p),a(o,h),a(h,v),a(h,$),a(h,b),a(n,y),a(n,k),a(k,w),a(w,S),a(w,C),a(w,I),a(w,_),a(w,L),a(w,E),a(w,T),a(w,q),a(w,A),a(w,z),a(w,B),a(k,H),a(k,O),Z.m(O,null),P=!0,j||(F=[g(b,"click",bt),g(b,"click",e[1]),g(S,"click",mt),g(S,"click",e[2]),g(I,"click",ht),g(I,"click",e[3]),g(L,"click",vt),g(L,"click",e[4]),g(T,"click",xt),g(T,"click",e[5]),g(A,"click",$t),g(A,"click",e[6]),g(B,"click",St)],j=!0)},p(e,[n]){1&n&&i(W,W=e[0])?(D(),V(Z,1,1,t),N(),Z=kt(),Z.c(),M(Z,1),Z.m(O,null)):Z.p(e,n)},i(t){P||(M(Z),P=!0)},o(t){V(Z),P=!1},d(t){t&&u(n),Z.d(t),j=!1,s(F)}}}async function St(){const t={motor:sessionStorage.getItem("motor"),displayText:sessionStorage.getItem("displayText"),displayVel:sessionStorage.getItem("displayVel"),led:sessionStorage.getItem("led")};await fetch("/execute-java",{method:"POST",headers:{"Content-Type":"application/json"},body:JSON.stringify(t)})}function Ct(t,e,n){let s="Home";return[s,()=>n(0,s="LOG"),()=>n(0,s="MG"),()=>n(0,s="LED"),()=>n(0,s="DT"),()=>n(0,s="UG"),()=>n(0,s="WM")]}return new class extends j{constructor(t){super(),P(this,t,Ct,wt,i,{})}}({target:document.getElementById("app")})}();
//# sourceMappingURL=bundle.js.map
