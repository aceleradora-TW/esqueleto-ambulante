import {getDev} from '../services/dev.service'
import Dev from '../Models/Dev'
const listMembers = [
    new Dev('Bárbara Suéllen Anger Nunes',1),
    new Dev('Brenda Brocardo', 2),
    new Dev('Cássia Gomes', 3),
    new Dev('Daniel Fernando da Silva', 4),
    new Dev('Daniela Araújo', 5),
    new Dev('Francielli Pinheiro Dias', 6),
    new Dev('Gabriel Farias', 7),
    new Dev('Ingrid Duarte', 8),
    new Dev('Jurley Colares Ribeiro', 9),
    new Dev('Luiza C. Lamarque', 10),
    new Dev('Maria Eduarda', 11),
    new Dev('Mayara Jesus de Oliveira', 12)
];

export default class DevForm {
    constructor() {
        this.makeMembersOptions(listMembers);
        this.showList(listMembers);
    }

    getMemberSelector () {
        return document.getElementById('dev-name')
    }
    
    submit(Form) {
        debugger;
        const selector = this.getMemberSelector();
        const member = selector ? selector.value || null : null;
        // getDev()
        // .then(response => response.data)
        // .then(user => {
        //     console.log(user);
        // })

        if(member)
        this.setMemberToLsit(member);
        return false;
    }
    setMemberToLsit(member){
        if(!listMembers.find(k => k.toLowerCase === member.toLowerCase))
        listMembers.push(member);
        this.showList(listMembers);
    }
    showList(items){
        const list = document.getElementById('members');
        this.removeAllMembers(list)
        items.forEach(element => {
            const item = document.createElement('li');
            item.classList.add('list-group-item', 'list-group-item-action');
            item.addEventListener('click', this.removeMember, th);
            item.appendChild(document.createTextNode(element.name));
            list.appendChild(item);
        });
    }
    removeAllMembers(list) {
        console.log(list)
        list.innerHTML = ""
    }
    makeMembersOptions(list) {  
        const select = this.getMemberSelector()
        list.forEach((element) => {
            const option = document.createElement('option')
            option.setAttribute("value", element.id);
            option.appendChild(document.createTextNode(element.name))            
            select.appendChild(option)
        });
    }
    removeMember() {
        console.log("click");
        
    }
}