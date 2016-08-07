'''
Function to transcribe DNA to RNA

RNA complements:
* `G` -> `C`
* `C` -> `G`
* `T` -> `A`
* `A` -> `U`
'''
COMPLEMENTS = {
    'G': 'C',
    'C': 'G',
    'T': 'A',
    'A': 'U'
}


def to_rna(dna):
    return ''.join([COMPLEMENTS[e] for e in dna])
