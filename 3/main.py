def compute_first_sets(grammar):
    first_sets = {}

    def compute_first(symbol):
        if symbol in first_sets:
            return first_sets[symbol]

        first_set = set()

        for production in grammar[symbol]:
            first_symbol = production.split()[0] 
            if first_symbol.islower() or first_symbol == '{e}':
                first_set.add(first_symbol)
            elif first_symbol.isupper():
                first_set |= compute_first(first_symbol)
                if '{e}' not in first_sets[first_symbol]:
                    break

        first_sets[symbol] = first_set
        return first_set

    for non_terminal in grammar:
        compute_first(non_terminal)

    return first_sets

def compute_follow_sets(grammar, first_sets):
    follow_sets = {non_terminal: set() for non_terminal in grammar}
    start_symbol = next(iter(grammar))
    follow_sets[start_symbol] = {'$'}

    def compute_follow(symbol):
        for lhs, productions in grammar.items():
            for production in productions:
                if symbol in production:
                    idx = production.index(symbol)
                    if idx == len(production) - 1: 
                        if lhs != symbol:
                            follow_sets[symbol] |= follow_sets[lhs]
                    else:
                        for next_char in production[idx + 1:]:
                            if next_char.islower():
                                follow_sets[symbol].add(next_char)
                                break
                            elif next_char.isupper():
                                follow_sets[symbol] |= first_sets[next_char]
                                if '{e}' not in first_sets[next_char]:
                                    break
                        else:
                            follow_sets[symbol] |= follow_sets[lhs]

    while True:
        old_follow_sets = {key: value.copy() for key, value in follow_sets.items()}

        for non_terminal in grammar:
            compute_follow(non_terminal)

        if old_follow_sets == follow_sets:
            break

    return follow_sets

def parse_input(input_string):
    grammar = {}
    lines = input_string.strip().split('\n')
    for line in lines:
        if ':' in line:
            parts = line.split(':')
            non_terminal = parts[0].strip()
            rules = [rule.strip() for rule in parts[1].split('|')]
            grammar[non_terminal] = rules
    return grammar

def format_output(first_sets, follow_sets, grammar):
    output = ""
    for non_terminal, rules in first_sets.items():
        for rule in grammar[non_terminal]:
            rule = rule.replace(';', '') 
            first_symbols = []
            for symbol in rule.split():
                if symbol.islower() or symbol == '{e}':
                    first_symbols.append(symbol)
                elif symbol.isupper():
                    first_symbols.extend(first_sets[symbol])
                    if '{e}' not in first_sets[symbol]:
                        break
            output += f"first[{non_terminal}:{rule}] = {' '.join(first_symbols)}\n"
    for non_terminal, follows in follow_sets.items():
        output += f"follow[{non_terminal}] = {' '.join(follows)}\n"
    return output

def main(input_string):
    grammar = parse_input(input_string)
    first_sets = compute_first_sets(grammar)
    follow_sets = compute_follow_sets(grammar, first_sets)
    return format_output(first_sets, follow_sets, grammar)

input_string = """A : b C | B d;
B : C C | b A;
C : c C | {e};"""
print(main(input_string))
