
var app2 = new Vue({
        el: '#app-2',
        data: {
            message: 'You loaded this page on ' + new Date()
        }
    })


var app = new Vue({
        el: '#app',
        data: {
            message: null
        }
    })

var app3 = new Vue({
    el: '#app-3',
    data: {
        seen: false,
        styleObject: {
            color: 'red',
            fontSize: '50px'
        },
        ifOk:true
    }
})

var app4 = new Vue({
    el: '#app-4',
    data: {
        todos: [
            { text: 'Learn JavaScript' },
            { text: 'Learn Vue' },
            { text: 'Build something awesome' }
        ]
    }
})

var app44 = new Vue({
    el: '#repeat-object',
    data: {
        object: [
            { name: 'wangwu' },
            { age:26 },
            { text: '我是帅哥哈哈哈' }
        ]
    }
})



var app5 = new Vue({
    el: '#app-5',
    data: {
        message: 'Hello Vue.js!'
    },
    methods: {
        reverseMessage: function () {
            // this.message = this.message.split('').reverse().join('')
            this.message =this.message.toLocaleUpperCase()
        }
    }
})


Vue.component('todo-item11', {
    props: ['todo1'],
    template: '<li>{{ todo1.text }}</li>'
})
var app7 = new Vue({
    el: '#app-7',
    data: {
        groceryList: [
            { text: 'Vegetables' },
            { text: 'Cheese' },
            { text: 'Whatever else humans are supposed to eat' }
        ]
    }
})


var vm = new Vue({
    el: '#example',
    data: {
        message: 'Hello'
    },
    computed: {
        reversedMessage11: function () {
           // return this.message.split('').reverse().join('')
            return new Date()
        }
    }
})


var vm = new Vue({
    el: '#demo',
    data: {
        firstName: 'Foo',
        lastName: 'Bar'
    },
    computed: {
        fullName: function () {
            return this.firstName + ' ' + this.lastName
        }
    }
})

var vm=new Vue({
    el:'#bind-test',
    data:{
        activeColor: 'red',
        fontSize: 30,
        styleObject: {
            color: 'red',
            fontSize: '50px'
        }
    }
})



Vue.component('todo-item', {
    template: '\
    <li>\
      {{ title }}\
      <button v-on:click="$emit(\'remove\')">X</button>\
    </li>\
  ',
    props: ['title']
})
new Vue({
    el: '#todo-list-example',
    data: {
        newTodoText: '',
        todos: [
            'Do the dishes',
            'Take out the trash',
            'Mow the lawn'
        ]
    },
    methods: {
        addNewTodo: function () {
            this.todos.push(this.newTodoText)
            this.newTodoText = ''
        }
    }
})



var example1 = new Vue({
    el: '#example-1',
    data: {
        counter: 0
    }
})


var example2=new Vue({
    el:'#example-2',
    data:{
        name:'Vue.Js'
    },
    methods:{
        greet:function (event1) {
            alert('Hello '+this.name)
            // alert(event1.target.tagName)
            alert(event1)
        }
    }
})


var example3=new Vue({
    el:'#example-3',
    data:{
        selected:''
    }
})
