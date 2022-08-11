package navigation.screens

import csstype.px
import domain.entities.Person
import domain.repository.TestPersonsRepository
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import mui.material.*
import mui.system.sx
import react.*
import react.dom.aria.ariaLabel
import react.dom.html.ReactHTML

val mainScope = MainScope()

val personsContent = FC<Props> {
    val personsRepo = TestPersonsRepository()

    var persons: List<Person> by useState(emptyList())

    useEffect {
        mainScope.launch {
            persons = personsRepo.getAllPersons()
        }
    }

    TableContainer {
        component = Paper.create().type

        //todo make table like that: https://mui.com/material-ui/react-table/#EnhancedTable.js

        Table {
            sx { minWidth = 650.px }
            ariaLabel = "simple table"

            TableHead {
                TableRow {
                    TableCell {
                        +"Имя"
                    }
                    TableCell {
                        align = TableCellAlign.right

                        +"Отчество"
                    }
                    TableCell {
                        align = TableCellAlign.right

                        +"Фамилия"
                    }
                    TableCell {
                        align = TableCellAlign.right

                        +"Кабинет"
                    }
                    TableCell {
                        align = TableCellAlign.right

                        +"Телефон"
                    }
                    TableCell {
                        align = TableCellAlign.right

                        +"email"
                    }
                }
            }

            TableBody {
                for (person in persons) {
                    TableRow {
                        key = person.id

                        TableCell {
                            component = ReactHTML.th
                            scope = "row"

                            +person.name
                        }
                        TableCell {
                            align = TableCellAlign.right

                            +person.middleName
                        }
                        TableCell {
                            align = TableCellAlign.right

                            +person.surname
                        }
                        TableCell {
                            align = TableCellAlign.right

                            +person.room
                        }
                        TableCell {
                            align = TableCellAlign.right

                            +person.phoneNumber
                        }
                        TableCell {
                            align = TableCellAlign.right

                            +person.eMail
                        }
                    }
                }
            }
        }
    }
}


