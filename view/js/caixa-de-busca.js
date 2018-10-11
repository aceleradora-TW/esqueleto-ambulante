module.exports = (moment, Pikaday) => ({
    seletorDeData: (elemento) => new Pikaday({
        field: document.querySelector(elemento),
        format: 'DD/MM/YYYY',
        i18n: {
            previousMonth: 'Mês Anterior',
            nextMonth: 'Próximo Mês',
            months: ['Janeiro', 'Fevereiro', 'Março', 'Abril', 'Maio', 'Junho', 'Julho', 'Agosto', 'Setembro', 'Outubro', 'Novembro', 'Dezembro'],
            weekdays: ['Domingo', 'Segunda', 'Terça', 'Quarta', 'Quinta', 'Sexta', 'Sábado'],
            weekdaysShort: ['Dom', 'Seg', 'Ter', 'Qua', 'Qui', 'Sex', 'Sab']
        },

        disableDayFn: function (date) {
            return moment().isAfter(moment(date), 'day');
        }
    })
});
