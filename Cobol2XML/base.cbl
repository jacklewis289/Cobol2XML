<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<cobol>
    <division>identification</division>
    <Program-ID>base</Program-ID>
    <day-date-written>7</day-date-written>
    <month-date-written>mar</month-date-written>
    <year-date-written>1995</year-date-written>
    <remarks>This program convert a value of a generic system base to a numeric value and viceversa .</remarks>
    <division>data</division>
    <section>working-storage</section>
    <Variable>
        <Variable Name="w_number"/>
        <w_number Type="integer"/>
        <w_number Value=""/>
        <w_number Length="16"/>
    </Variable>
    <Variable>
        <Variable Name="entry_number"/>
        <entry_number Type="integer"/>
        <entry_number Value=""/>
        <entry_number Length="16"/>
    </Variable>
    <Variable>
        <Variable Name="current_base"/>
        <current_base Type="integer"/>
        <current_base Value=""/>
        <current_base Length="2"/>
    </Variable>
    <Constant>
        <Constant Name="base_2"/>
        <base_2 Line_Number="88"/>
        <base_2 Value="2.0"/>
    </Constant>
    <Constant>
        <Constant Name="base_8"/>
        <base_8 Line_Number="88"/>
        <base_8 Value="8.0"/>
    </Constant>
    <Constant>
        <Constant Name="base_10"/>
        <base_10 Line_Number="88"/>
        <base_10 Value="10.0"/>
    </Constant>
    <Constant>
        <Constant Name="base_16"/>
        <base_16 Line_Number="88"/>
        <base_16 Value="16.0"/>
    </Constant>
    <String>
        <String Name="hex_dec_data"/>
        <hex_dec_data Type="string"/>
        <hex_dec_data Value=""/>
        <hex_dec_data Length="48"/>
    </String>
    <division>procedure</division>
    <comment>convert from decimal to base system</comment>
    <comment>convert from base to dicimal system</comment>
    <comment>allineamento a destra della variabile entry_char ( ver 2.3 0.1 o sup )</comment>
</cobol>
