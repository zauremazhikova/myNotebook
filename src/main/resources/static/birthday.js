
var birthdaysListApi = Vue.resource('/birthday/listOfBirthdays');

Vue.component('birthday-form',{
    props: ['birthdays'],
    data: function(){
        return{
            person: '',
            date: ''
        }
    },
    template:
        '<div> ' +
            '<input type="text" placeholder="Person" v-model="person"/>'+
            '<input type="date" placeholder="Date" v-model="date"/>'+
            '<input type="button" value="Save" v-on:click="save"/>'+ //можно так: @click = "save"
        '</div>',
    methods:{
        save: function () {
            var person = {person: this.person};
            var date = {date: this.date};
            birthdaysListApi.save({}, person, date).then(result =>
                result.json().then(data => {
                    this.birthdays.push(data);
                    this.person = '';
                    this.date = '';
                })
            );
        }
    }
});

Vue.component('birthday-row',{
    props: ['birthday'],
    template: '<div><i>{{birthday.id }}</i> {{birthday.text}}</div>'
});

Vue.component('birthdays-list',{
    props: ['birthdays'],
    template:
        '<div>' +
        '<birthday-form :birthdays="birthdays" />' +
        '<birthday-row v-for="birthday in birthdays" :key="birthday.id" :birthday = "birthday"/> ' +
        '</div>',
    created: function () {
        birthdaysListApi.get().then(result =>
            result.json().then(data =>
                data.forEach(birthday => this.birthdays.push(birthday))
            )
        )
    }
});

var app = new Vue({
    el: '#app',
    template: '<birthdays-list :birthdays="birthdays" />',
    data: {
        birthdays: [
        ]
    }
});