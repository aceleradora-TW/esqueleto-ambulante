import axios from 'axios';
const client = axios.create({
    baseURL: 'https://api.github.com/',
    timeout: 5000});


    export default client;